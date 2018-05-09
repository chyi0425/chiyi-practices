package com.chiyi.leetcode;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 */
public class NextGreaterElementITest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void nextGreaterElement() throws Exception {
        int[] findNums = {4,1,2};
        int[] nums = {1,3,4,2};
        int[] excepted = {-1,3,-1};
        assertArrayEquals(excepted,new NextGreaterElementI().nextGreaterElement(findNums,nums));
    }

    @Test
    public void testNewFile() throws Exception {
        File f1 = new File("C:/myDir");
        System.out.println("Check for existence==>"+f1.exists());
        try {
            f1.mkdir();
            File f2 = new File("C:/myDir/testFile.txt");
            f2.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}