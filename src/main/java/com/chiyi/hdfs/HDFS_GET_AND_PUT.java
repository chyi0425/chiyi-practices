package com.chiyi.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class HDFS_GET_AND_PUT {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://10.10.10.231:9000");
        conf.set("fs.replication","2");
        FileSystem fs = FileSystem.get(conf);


        System.setProperty("HADOOP_USER_NAME","hadoop");

        fs.copyFromLocalFile(new Path("D:/sss.txt"),new Path("/test/input/ggg.txt"));

        FSDataInputStream is = fs.open(new Path("/test/input/ggg.txt"));
        byte[] buff = new byte[1024];
        int length = 0;

        while ((length=is.read(buff))!=-1){
            System.out.println(new String(buff,0,length));
        }
        System.out.println(fs.getClass().getName());
//        fs.copyToLocalFile(new Path("/test/input/ggg.txt"),new Path("D:/ggg3.txt"));

        fs.close();
    }

}
