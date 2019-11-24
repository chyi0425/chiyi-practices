package com.chiyi.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chiyi
 * @date 2019/9/17.
 */
public class IteratorTest {
    public static void iteratorForIntTest(int[] arr) {
        long timeStart = System.currentTimeMillis();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println("Iterator 比较int最小值 花费的时间" + (timeEnd - timeStart));
    }

    public static void iteratorForObjectTest(List<Student> studentList) {
        long timeStart = System.currentTimeMillis();
        Map<String, List<Student>> stuMap = new HashMap<String, List<Student>>();

        for (Student stu : studentList) {
            if (stu.getHeight() > 160) {
                if (stuMap.get(stu.getSex()) == null) {
                    List<Student> list = new ArrayList<Student>();
                    list.add(stu);
                    stuMap.put(stu.getSex(), list);
                }else {
                    stuMap.get(stu.getSex()).add(stu);
                }
            }
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println("Iterator花费的时间" + (timeEnd - timeStart));
    }
}
