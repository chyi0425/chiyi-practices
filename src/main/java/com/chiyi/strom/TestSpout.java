package com.chiyi.strom;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * 发送信息
 */
public class TestSpout extends BaseRichSpout {
    private SpoutOutputCollector collector;
    private static final String field = "word";
    private int count = 1;
    private String[] message = {
            "My nickname is xuwujing",
            "My blog address is http://www.panchengming.com/",
            "My interest is playing games"
    };


    /**
     * 在Spout组件初始化时被调用。
     *
     * @param map                  strom配置的map
     * @param topologyContext      topology中组件的信息
     * @param spoutOutputCollector 发射tuple的方法
     */
    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        System.out.println("open:" + map.get("test"));
        this.collector = spoutOutputCollector;
    }

    /**
     * 是Spout的核心。
     * 也就是主要的执行方法，用于输出信息，通过collector.emit方法发射。
     */
    @Override
    public void nextTuple() {
        if (count < message.length) {
            System.out.println("第"+count +"次开始发送数据...");
            this.collector.emit(new Values(message[count-1]));
        }
        count++;
    }


    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        System.out.println("定义格式...");
        outputFieldsDeclarer.declare(new Fields(field));
    }

    @Override
    public void ack(Object msgId) {
        System.out.println("ack:"+msgId);;
    }


    /**
     * 当Topology停止时，会调用这个方法
     */
    @Override
    public void close() {
        System.out.println("关闭...");
    }

    /**
     * 当一个Tuple处理失败时，会调用这个方法
     */
    @Override
    public void fail(Object obj) {
        System.out.println("失败:"+obj);
    }

}
