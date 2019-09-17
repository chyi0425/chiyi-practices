package com.chiyi.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author chiyi
 * @date 2019/9/17.
 */
public class App {
    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<Student>();

        for(int i=0; i<10000000; i++) {
            Student stu = new Student();
            stu.setHeight(156 + i);
            stu.setSex(String.valueOf(i%2));
            studentsList.add(stu);

        }
            IteratorTest.iteratorForObjectTest(studentsList);
            SerialStreamTest.serialStreamForObjectTest(studentsList);
            ParallelStreamTest.parallelStreamForObjectTest(studentsList);

        int[] arr = new int[100000000];

    	Random r = new Random();
		for(int i=0; i<arr.length; i++){
			arr[i] = r.nextInt();
		}

    	IteratorTest.iteratorForIntTest(arr);
    	SerialStreamTest.serialStreamForIntTest(arr);
    	ParallelStreamTest.parallelStreamForIntTest(arr);

    }
}
