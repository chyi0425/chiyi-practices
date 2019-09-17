package com.chiyi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chiyi
 * @date 2019/9/17.
 */
public class ParallelStreamTest {
    public static void parallelStreamForIntTest(int[] arr) {
        long timeStart = System.currentTimeMillis();

        Arrays.stream(arr).parallel().min().getAsInt();
        long timeEnd = System.currentTimeMillis();
        System.out.println("ParallelStream  比较int最小值 花费的时间" + (timeEnd - timeStart));

    }

    public static void parallelStreamForObjectTest(List<Student> studentList) {
        long timeStart = System.currentTimeMillis();

        Map<String, List<Student>> stuMap = studentList.parallelStream().filter((Student s) -> s.getHeight() > 160).collect(Collectors.groupingBy(Student::getSex));
        long timeEnd = System.currentTimeMillis();
        System.out.println("Stream并行花费的时间" + (timeEnd - timeStart));

    }
}
