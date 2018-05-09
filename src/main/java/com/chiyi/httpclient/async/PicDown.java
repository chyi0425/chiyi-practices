package com.chiyi.httpclient.async;

/**
 * @author chiyi
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.client.methods.ZeroCopyConsumer;
import org.apache.http.nio.protocol.BasicAsyncRequestProducer;
import org.apache.http.util.EntityUtils;


//selector空轮询，cpu使用100%的bug
//<dependency>
//<groupId>org.apache.httpcomponents</groupId>
//<artifactId>httpasyncclient</artifactId>
//<version>4.1.3</version>
//</dependency>
public class PicDown {

    final static Pattern HOT_COUNT_REGEX = Pattern
            .compile("span id.*?a href=\"([^\"]*?)\".*?被顶(\\d+)次", Pattern.DOTALL);
    final static Pattern PIC_ATTACHMENT_URL_REGEX = Pattern.compile("file=\"(attachments[^\"]*)\"", Pattern.DOTALL);
    final static Pattern TITLE_REGEX = Pattern.compile("<h1>(.*)</h1>");
    final static Pattern SPECIAL_CHARACTER_REGEX = Pattern
            .compile("[\\.|\\]|\\[|\\s|●|！|】|【|~|@|\\|\\?|\"|/|\\\\|<|>|*|\\|:]*");

    final String host;
    final String downDir;
    int start;
    int end;
    int hotThrottle;
    int interval;
    //LinkedBlockingQueue<Worker> queue = new LinkedBlockingQueue<PicDown.Worker>();
    CloseableHttpAsyncClient client;

    public PicDown(String params) {
        Map<String, String> map = new HashMap<>();
        String[] paramsSpilt = params.split("&");
        for (String s : paramsSpilt) {
            String[] split = s.split("=");
            map.put(split[0], split[1]);
        }

        host = map.getOrDefault("host", "93.t9p.today");
        String proxyHost = map.get("proxyHost");
        String proxyPort = map.get("proxyPort");

        HttpHost proxy = null;
        if (proxyHost != null) {
            proxy = new HttpHost(proxyHost, Integer.valueOf(proxyPort));
        }

        String dr = map.getOrDefault("downDir", System.getProperty("java.io.tmpdir"));
        if (!dr.endsWith("/")) {
            downDir = dr + "/";
        } else {
            downDir = dr;
        }
        System.out.println(downDir);

        start = Integer.valueOf(map.getOrDefault("start", "1"));
        end = Integer.valueOf(map.getOrDefault("end", "20"));
        hotThrottle = Integer.valueOf(map.getOrDefault("hotThrottle", "20"));
        interval = Integer.valueOf(map.getOrDefault("interval", "30"));
        this.initHttpClient(proxy);
    }


    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("Usage:  java -jar PicDown \"host=xxx&"
                    + "downDir=default System.getProperties(java.io.tmpdir)&start=1&end=20"
                    + "&hotThrottle=20&interval=30&proxyHost=127.0.0.1&proxyPort=1080\"");
            System.exit(1);
        }
        PicDown p = new PicDown(args[0]);
        p.start();
    }

    public void initHttpClient(HttpHost proxy) {
        HttpAsyncClientBuilder builder = HttpAsyncClientBuilder.create();
        builder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
        builder.setConnectionReuseStrategy(new DefaultConnectionReuseStrategy());
        RequestConfig config = RequestConfig.custom().setConnectTimeout(20000).
                setConnectionRequestTimeout(30000).build();
        builder.setDefaultRequestConfig(config);
        if (proxy != null) {
            builder.setProxy(proxy);
            builder.setProxyAuthenticationStrategy(ProxyAuthenticationStrategy.INSTANCE);
        }
        IOReactorConfig io = IOReactorConfig.custom()
                .setTcpNoDelay(false)
                .build();
        builder.setDefaultIOReactorConfig(io);
        builder.setMaxConnTotal(10).setMaxConnPerRoute(10);
        client = builder.build();
        client.start();
    }


    public void start() {
        for (int i = start; i <= end; i++) {
            final String urlPrfix = "http://" + host + "/forumdisplay.php?fid=19&page=";
            final String geturl = urlPrfix + i;
            HttpGet pages = new HttpGet(geturl);
            pages.addHeader("Connection", "keep-alive");
            pages.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
            pages.addHeader("Referer", urlPrfix + (i - 1));
            pages.addHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
            client.execute(pages, new ThemeHandler(geturl));
            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //网络请求量大的情况，优先级比较难控制
//	class FileWriter extends Thread {
//
//
//		@Override
//		public void run() {
//			for(int i=0;;i++){
//				if(i%5==0){
//					try {
//						Thread.sleep(10000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				try {
//					Worker w=queue.take();
//					w.run();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}

    private final class ThemeHandler implements FutureCallback<HttpResponse> {

        private final String geturl;

        private ThemeHandler(String geturl) {
            this.geturl = geturl;
        }

        @Override
        public void failed(Exception ex) {
            ex.printStackTrace();
        }

        @Override
        public void completed(HttpResponse result) {
            try {
                String content = EntityUtils.toString(result.getEntity(), Charset.forName("utf-8"));
                Matcher m = HOT_COUNT_REGEX.matcher(content);
                while (m.find()) {
                    Integer count = Integer.valueOf(m.group(2));
                    if (count > hotThrottle) {
                        final String url = m.group(1).replaceAll("&amp;", "&");
                        System.out.println("http://" + host + "/" + url);
                        HttpGet picUrl = new HttpGet("http://" + host + "/" + url);
                        picUrl.addHeader("Connection", "keep-alive");
                        picUrl.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
                        picUrl.addHeader("Referer", geturl);
                        picUrl.addHeader("User-Agent",
                                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
                        client.execute(picUrl, new PicAttachmentHandler(url));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void cancelled() {
            System.out.println("cancelled");
        }
    }


    private final class PicAttachmentHandler implements FutureCallback<HttpResponse> {

        private final String url;

        private PicAttachmentHandler(String url) {
            this.url = url;
        }

        @Override
        public void failed(Exception ex) {
            ex.printStackTrace();
        }

        @Override
        public void completed(HttpResponse result) {
            System.out.println(url + " fetching");
            try {
                String content = EntityUtils.toString(result.getEntity(), Charset.forName("utf-8"));
                Matcher mTitle = TITLE_REGEX.matcher(content);
                String title = "";
                if (mTitle.find()) {
                    title = mTitle.group(1);
                    if (title.contains("<a class=")) {
                        return;
                    }
                    System.out.print(title);
                    title = SPECIAL_CHARACTER_REGEX.matcher(title).replaceAll("");
//												File f = new File(dir+title);
//												if(f.exists()){
//													System.out.println(" 已存在");
//													return;
//												}
//												System.out.println();

                }
                Matcher m = PIC_ATTACHMENT_URL_REGEX.matcher(content);

                List<String> paths = new ArrayList<String>();
                while (m.find()) {
                    String url = m.group(1);
                    System.out.println(url);
                    paths.add(url);
                }
                //使用队列 网络请求的优先级比较乱，效率可能会降低
                //直接在此处使用async的zerocopy下载图片
                Worker w = new Worker();
                w.fileDir = downDir;
                w.paths = paths;
                w.title = title;
                w.run();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void cancelled() {
            System.out.println("cancelled");

        }
    }


    class Worker implements Runnable {

        String title;
        List<String> paths;
        String fileDir;

        @Override
        public void run() {
            if (paths == null || paths.size() == 0) {
                return;
            }
            if (title == null || title.length() == 0) {
                title = UUID.randomUUID().toString().replaceAll("-", "");
            } else {
                System.out.println(title + " : download pic");
            }
            File f = new File(fileDir + title);
            if (!f.exists() || !f.isDirectory()) {
                f.mkdirs();
            }
            for (String path : paths) {
                try {
                    String picFullName = "http://" + host + "/" + path;
                    String picName = picFullName.substring(picFullName.lastIndexOf("/") + 1);
                    final String fileName = fileDir + title + "/" + picName;
                    File ff = new File(fileName);
                    if (ff.exists() && ff.length() > 100) {
                        continue;
                    }
                    URIBuilder b = new URIBuilder(picFullName);
                    HttpGet get = new HttpGet(b.build());
                    get.addHeader("Connection", "keep-alive");
                    get.addHeader("User-Agent",
                            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
                    BasicAsyncRequestProducer producer = new BasicAsyncRequestProducer(new HttpHost(b.getHost()), get);
                    client.execute(producer, new FileDownload(new File(fileName)), null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }


    class FileDownload extends ZeroCopyConsumer<File> {

        public FileDownload(File file) throws FileNotFoundException {
            super(file);
        }

        @Override
        protected File process(HttpResponse response, File file,
                ContentType contentType) throws Exception {
            return file;
        }
    }

//    static class ProxyConnectingIOReactor extends DefaultConnectingIOReactor {
//
//    	private InetSocketAddress addr;
//
//        public ProxyConnectingIOReactor(final IOReactorConfig config,InetSocketAddress addr) throws IOReactorException {
//        	super(config);
//            this.addr = addr;
//        }
//
//        @Override
//        public SessionRequest connect(
//                final SocketAddress remoteAddress,
//                final SocketAddress localAddress,
//                final Object attachment,
//                final SessionRequestCallback callback) {
//        	return super.connect(addr, localAddress, attachment, callback);
//        }
//
//
//    }
}

