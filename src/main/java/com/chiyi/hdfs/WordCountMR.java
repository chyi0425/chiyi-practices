package com.chiyi.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

public class WordCountMR {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://10.10.10.231:9000");
        System.setProperty("HADOOP_USER_NAME", "hadoop");
        conf.addResource("hdfs_config/core-site.xml");
        conf.addResource("hdfs_config/hdfs-site.xml");
        conf.set("mapreduce.framework.name", "yarn");
        Job job = Job.getInstance(conf);
    }
}
