package com.chiyi.algorithms.sorting.elementary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class SelectionTest {
    private Random random = new Random();
    public static final ArrayList<Double> list = new ArrayList<Double>(1000000);
    @Test
    public void givenStaticField_whenLotsOfOperations_thenMemoryLeak() throws InterruptedException {
        Thread.sleep(10000); // to allow GC do its job
        for (int i = 0; i < 1000000; i++) {
            list.add(random.nextDouble());
        }

        System.gc();
        Thread.sleep(10000); // to allow GC do its job
    }

    @Test
    public void givenNormalField_whenLotsOfOperations_thenGCWorksFine() throws InterruptedException {
        Thread.sleep(10000); // to allow GC do its job
        addElementsToTheList();
        System.gc();
        Thread.sleep(10000); // to allow GC do its job
    }

    private void addElementsToTheList(){
        ArrayList<Double> list = new ArrayList<Double>(1000000);
        for (int i = 0; i < 1000000; i++) {
            list.add(random.nextDouble());
        }
    }

    @Test
    public void sort() {
        String parameters = "SORTEXAMPLE";
        char[] chars = parameters.toCharArray();
        Character[] characters = new Character[11];
        for(int i=0;i<characters.length;i++){
            characters[i] = chars[i];
        }
        Selection.sort(characters);
    }
}