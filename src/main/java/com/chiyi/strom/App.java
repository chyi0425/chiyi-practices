package com.chiyi.strom;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

public class App {
    private static final String test_spout="test_spout";
    private static final String test_bolt="test_bolt";
    private static final String test2_bolt="test2_bolt";

    public static void main(String[] args) {
        // 定义一个拓扑
        TopologyBuilder builder = new TopologyBuilder();
        // 设置一个Executor，默认1
        builder.setSpout(test_spout,new TestSpout(),1);
        //设置一个Executeor(线程)，和一个task
        builder.setBolt(test_bolt,new TestBolt(),1).setNumTasks(1).shuffleGrouping(test_spout);
        builder.setBolt(test2_bolt,new Test2Bolt(),1).setNumTasks(1).fieldsGrouping(test_bolt,new Fields("count"));
        Config conf = new Config();
        conf.put("test","test");

        try {
            if(args !=null&&args.length>0){ //有参数时，表示向集群提交作业，并把第一个参数当做topology名称
                System.out.println("远程模式");
                StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
            } else{//没有参数时，本地提交
                //启动本地模式
                System.out.println("本地模式");
                LocalCluster cluster = new LocalCluster();
                cluster.submitTopology("Word-counts",conf,builder.createTopology());
                Thread.sleep(20000);
                cluster.shutdown();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
