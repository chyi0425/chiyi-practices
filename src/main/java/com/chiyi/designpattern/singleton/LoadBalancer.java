package com.chiyi.designpattern.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author chiyi
 * 模拟负载均衡器单例
 */
public class LoadBalancer {
    // 私有静态成员变量，存储唯一实例
    private volatile static LoadBalancer instance = null;

    // 服务器集合
    private List<String> serverList = null;

    private LoadBalancer(){
        serverList = new ArrayList<String>();
    }

    public static  LoadBalancer getLoadBalancer(){
        if(instance == null){
            synchronized (LoadBalancer.class){
                if(instance==null){
                    instance = new LoadBalancer();
                }
            }
        }
        return instance;
    }

    public void addServer(String server){
        serverList.add(server);
    }

    public void removeServer(String server){
        serverList.remove(server);
    }

    public String getServer(){
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return serverList.get(i);
    }
}
