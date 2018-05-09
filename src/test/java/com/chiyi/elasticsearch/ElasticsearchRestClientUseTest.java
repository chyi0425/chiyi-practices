package com.chiyi.elasticsearch;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.minidev.json.JSONUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseException;
import org.elasticsearch.client.RestClient;
import org.junit.Before;
import org.junit.Test;
import us.codecraft.webmagic.selector.Json;

import static org.junit.Assert.*;

/**
 * @author chiyi
 */
public class ElasticsearchRestClientUseTest {

    private String endpoint = "/test-ocean-doc/docs/";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_PUT = "PUT";
    private static final String METHOD_POST = "POST";

    private RestClient restClient;

    @Before
    public void setUp() throws Exception {
//        restClient = RestClient.builder(new HttpHost("10.18.3.167", 9200, "http")).build();
        restClient = RestClient.builder(new HttpHost("10.18.3.27", 9201, "http")).build();
    }

    @Test
    public void initTest() throws Exception {

    }

    @Test
    public void catApi() throws Exception {
        String endPoint = "/_cat";
        Response response = restClient.performRequest(METHOD_GET, endPoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void createIndex() throws Exception {
        String endPoint = "/test-ocean-doc";
        Response response = restClient.performRequest(METHOD_PUT, endPoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void createDocument() throws Exception {
        String endpoint = "/test-ocean-doc/docs/";
        DocVo docVo = new DocVo("1001", "1", "测试1", "test",
                "1测试1description", "和我看见打完idjawoifjioawfjioawjfas空间可视角度会计网，挖地基发给我哦看哦我", "0", "0", "chiyi",
                new Date(), new Date(), "");
        HttpEntity entity = new NStringEntity(JSON.toJSONString(docVo), ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest(METHOD_PUT, endpoint + docVo.getDoc_resource_id(),
                Collections.<String, String>emptyMap(), entity);
        System.out.println(EntityUtils.toString((response.getEntity())));

    }

    @Test
    public void getDocument() throws Exception {
        String endpoint = "/test-ocean-doc/docs/1006";
        try {
            Response response = restClient.performRequest(METHOD_GET, endpoint);
            System.out.println(response);
            System.out.println(EntityUtils.toString(response.getEntity()));

        } catch (ResponseException e) {
            e.printStackTrace();
        }

    }

    /**
     * 查询所有数据
     *
     * @throws Exception
     */
    @Test
    public void QueryAll() throws Exception {
        HashMap<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("content", "我看");
        String endpoint = "/Mobile_hot_recom_201802/docs/_search";
        JSONObject parameter = new JSONObject();
        JSONObject query = new JSONObject();
        query.put("match_phrase", paramMap);
        parameter.put("query", query);
        parameter.put("size", 20);
        HttpEntity entity = new NStringEntity(parameter.toJSONString(), ContentType.APPLICATION_JSON);

        Response response = restClient
                .performRequest(METHOD_POST, endpoint, Collections.<String, String>emptyMap(), entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    public void queryDocsByCateId(String cateId, int limit) throws Exception {
        Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("doc_cate_id", cateId);
        queryResultByMatch(paraMap, limit);
    }

    private Object queryResultByMatch(Map<String, String> paramMap, int limit) throws IOException {
        JSONObject query = new JSONObject();
        query.put("match", paramMap);
        return queryResult(query, limit);
    }

    private Object queryResultByMatchPhrase(Map<String, String> paramMap, int limit) throws IOException {
        JSONObject query = new JSONObject();
        query.put("match_phrase", paramMap);
        return queryResult(query, limit);
    }

    private Object queryResultByRange(Map<String, Map<String, String>> paramMap, int limit) throws IOException {
        JSONObject query = new JSONObject();
        query.put("range", paramMap);
        return queryResult(query, limit);
    }

    private Object queryResult(JSONObject query, int limit) throws IOException {
        JSONObject parameter = new JSONObject();
        parameter.put("query", query);
        parameter.put("size", limit);
        HttpEntity entity = new NStringEntity(parameter.toJSONString(), ContentType.APPLICATION_JSON);
        Response response = restClient
                .performRequest(METHOD_POST, endpoint + "_search", Collections.<String, String>emptyMap(), entity);
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }

    @Test
    public void hashmapTest() {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 1; i < 1000; i++) {
            map.put(i, String.valueOf(i));
        }
        System.out.println(map.size());
    }

    @Test
    public void subStringTest() {
//        String value = "我看<em class='highlight'>就</em>就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德<em class='highlight'>就</em>基快捷酒店今年我看就是肯<em class='highlight'>就</em>德基快捷酒店今年我看就<em class='highlight'>就</em>是肯德基快捷酒店今年我<em class='highlight'>就</em>看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看<em class='highlight'>就</em>是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年<em class='highlight'>你</em>们我来咯我";
//        String value = "是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年<em class='highlight'>你</em>们我来咯我肯德基快捷酒";
//        String value = "是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年<em class='highlight'>你</em>们我来咯我肯德基快捷酒";
        String value = "是肯德<em class='highlight'>酒</em>基快捷酒店今年我看就是<em class='highlight'>看就</em>肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年<em class='highlight'>你</em><em class='highlight'>你</em><em class='highlight'>你</em><em class='highlight'>你</em>们我来咯我肯德基快捷酒是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德基快捷酒店今年我看就是肯德是肯德基快捷酒";


        Map<Integer,Integer> hightlightTagBeginMap = countStringSub(value,"<em class='highlight'>");
        Map<Integer,Integer> hightlightTagEndMap = countStringSub(value,"</em>");
        Set<String> hightlightSet = new HashSet<String>();
        Set<String> withoutHightlightSet = new HashSet<String>();
        Map<String,String> highlightMap = new HashMap<>();
        int highlightSize = hightlightTagBeginMap.size();
        for(int i=1;i<=highlightSize;i++){
            highlightMap.put(value.substring(hightlightTagBeginMap.get(i)+22,hightlightTagEndMap.get(i)),value.substring(hightlightTagBeginMap.get(i),hightlightTagEndMap.get(i)+5));
            hightlightSet.add(value.substring(hightlightTagBeginMap.get(i),hightlightTagEndMap.get(i)+5));
            withoutHightlightSet.add(value.substring(hightlightTagBeginMap.get(i)+22,hightlightTagEndMap.get(i)));
        }
        System.out.println(hightlightSet);
        System.out.println(withoutHightlightSet);

        int valueLength = value.length();
        int firstEm = value.indexOf("<em");

        Iterator<Entry<String,String>> highlightMapIterator = highlightMap.entrySet().iterator();
        while (highlightMapIterator.hasNext()){
            Entry<String,String> entry = highlightMapIterator.next();
            value = value.replaceAll(entry.getValue(),entry.getKey());
        }

        int beginIndex;
        int endIndex;
        if (valueLength - firstEm < 50) {
            endIndex = valueLength;
            beginIndex = valueLength -100;
        } else if (firstEm > 50) {
            beginIndex = firstEm - 50;
            endIndex = firstEm + 50;
        } else {
            beginIndex = 0;
            endIndex = 110;
        }
        String newValue = value.substring(beginIndex, endIndex);
        Iterator<Entry<String,String>> iterator = highlightMap.entrySet().iterator();
        while (iterator.hasNext()){
            Entry<String,String> entry = iterator.next();
            newValue = newValue.replaceAll(entry.getKey(),entry.getValue());
        }
        System.out.println(firstEm);
        System.out.println(newValue);
    }

    public  Map<Integer,Integer> countStringSub(String content, String subStr) {
        int index = 0;
        int count = 0;
        int fromIndex = 0;
        Map<Integer,Integer> countPositionMap = new HashMap<Integer, Integer>();
        while ((index = content.indexOf(subStr, fromIndex)) != -1) {
            fromIndex = index + subStr.length();
            count++;
            countPositionMap.put(count,index);
        }
        return countPositionMap;
    }
}