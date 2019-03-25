package com.chiyi.dubbo;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author chiyi
 * @date 2019/3/25.
 */
public class MinaTest {
    public static void main(String[] args) throws IOException {
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(
                new TextLineCodecFactory(Charset.forName("UTF-8"),"\r\n","\r\n")
        ));

        acceptor.setHandler((IoHandler) new TcpServerHandler());
        acceptor.bind(new InetSocketAddress(8080));
    }
}
