package com.chiyi.algorithms.sorting.elementary;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShellTest {

    @Test
    public void sort() {
        String parameters = "SORTEXAMPLE";
        char[] chars = parameters.toCharArray();
        Character[] characters = new Character[11];
        for(int i=0;i<characters.length;i++){
            characters[i] = chars[i];
        }
        Shell.sort(characters);
        System.out.println(characters);
    }
}