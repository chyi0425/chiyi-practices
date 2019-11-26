package com.chiyi.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.maxBy;

public class TestCase {
    public static void main(String[] args) {
        // collect(Collectors.toList())
        List<Student> studentList = Stream.of(new Student("路飞", 22, 175),
                new Student("红发", 40, 180),
                new Student("白胡子", 50, 185)).collect(Collectors.toList());
        System.out.println(studentList);

        // filter
        List<Student> list = studentList.stream().filter(stu -> stu.getStature() < 180).collect(Collectors.toList());
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
        Optional<Student> max = studentList2.stream().max(comparing(student -> student.getAge()));
        Optional<Student> min = studentList2.stream().min(comparing(student -> student.getAge()));
        if (max.isPresent()) {
            System.out.println(max.get());
        }
        if (min.isPresent()) {
            System.out.println(min.get());
        }

        // count(generally combined with filter)
        long count = studentList2.stream().filter(student -> student.getAge() < 45).count();
        System.out.println("Number of people under the age of 45:" + count);

        //
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (acc, x) -> acc + x);
        System.out.println(reduce);

        OutstandingClass ostClass1 = new OutstandingClass("一班", studentList);
        List<Student> students2 = new ArrayList<>(studentList);
        students2.remove(1);
        OutstandingClass ostClass2 = new OutstandingClass("二班", students2);
        Stream<OutstandingClass> classStream = Stream.of(ostClass1, ostClass2);
        OutstandingClass outstandingClass = biggestGroup(classStream);
        System.out.println("人数最多的班级是：" + outstandingClass.getName());
        System.out.println("一班平均年龄是：" + averageNumberOfStudent(studentList));



    }

    private static double averageNumberOfStudent(List<Student> studentList) {
        return studentList.stream().collect(averagingInt(Student::getAge));
    }

    private static OutstandingClass biggestGroup(Stream<OutstandingClass> classStream) {
        return classStream.collect(
                maxBy(comparing(ostClass -> ostClass.getStudents().size())))
                .orElseGet(OutstandingClass::new);
    }
}
