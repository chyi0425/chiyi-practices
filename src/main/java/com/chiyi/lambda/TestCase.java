package com.chiyi.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCase {
    public static void main(String[] args) {
        // collect(Collectors.toList())
        List<Student> studentList = Stream.of(new Student("路飞", 22, 175),
                new Student("红发",40,180),
                new Student("白胡子",50,185)).collect(Collectors.toList());
        System.out.println(studentList);

        // filter
        List<Student> list = studentList.stream().filter(stu -> stu.getStature()<180).collect(Collectors.toList());
        System.out.println(list);

        // map
        List<String> names = studentList.stream().map(student -> student.getName()).collect(Collectors.toList());
        System.out.println(names);

        // flatMap : Combine multiple streams into one streams
        List<Student> studentList2 = Stream.of(studentList, Arrays.asList(
                new Student("艾斯", 25, 183),
                new Student("雷利", 48, 176)))
                .flatMap(students -> students.stream()).collect(Collectors.toList());
        System.out.println(studentList2);

        // max min
        Optional<Student> max = studentList2.stream().max(Comparator.comparing(student -> student.getAge()));
        Optional<Student> min  = studentList2.stream().min(Comparator.comparing(student -> student.getAge()));
        if(max.isPresent()){
            System.out.println(max.get());
        }
        if (min.isPresent()){
            System.out.println(min.get());
        }

        // count(generally combined with filter)
        long count = studentList2.stream().filter(student -> student.getAge()<45).count();
        System.out.println("Number of people under the age of 45:"+count);

        //
        Integer reduce = Stream.of(1,2,3,4).reduce(0,(acc,x)->acc+x);
    }
}
