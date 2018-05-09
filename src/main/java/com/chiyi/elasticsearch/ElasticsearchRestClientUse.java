package com.chiyi.elasticsearch;

import java.io.IOException;
import java.util.Collections;

import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

/**
 * @author chiyi
 */
public class ElasticsearchRestClientUse {

    public void initTest()throws IOException {
        RestClient restClient = RestClient.builder(new HttpHost("10.18.3.167",9200,"http")).build();
        Response response = restClient.performRequest("GET","/", Collections.singletonMap("pretty","true"));
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
