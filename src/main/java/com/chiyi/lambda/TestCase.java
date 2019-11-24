package com.chiyi.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCase {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(new Student("路飞", 22, 175),
                new Student("红发",40,180),
                new Student("白胡子",50,185)).collect(Collectors.toList());
        System.out.println(studentList);

        List<Student> list = studentList.stream().filter(stu -> stu.getStature()<180).collect(Collectors.toList());
        System.out.println(list);
    }
}
