package com.chiyi.strom;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

public class Test2Bolt extends BaseRichBolt {
    /**
     * 保存单词和对应的计数
     */
    private HashMap<String, Integer> counts = null;

    private long count=1;
    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        System.out.println("prepare:"+map.get("test"));
        this.counts=new HashMap<String, Integer>();
    }

    /**
     * execute()方法是Bolt实现的核心。
     * 也就是执行方法，每次Bolt从流接收一个订阅的tuple，都会调用这个方法。
     *
     */
    @Override
    public void execute(Tuple tuple) {
        String msg=tuple.getStringByField("count");
        System.out.println("第"+count+"次统计单词出现的次数");
        if (!counts.containsKey(msg)) {
            counts.put(msg, 1);
        } else {
            counts.put(msg, counts.get(msg)+1);
        }
        count++;
    }

    @Override
    public void cleanup() {
        System.out.println("===========开始显示单词数量============");
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("===========结束============");
        System.out.println("Test2Bolt的资源释放");
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
