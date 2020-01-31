package com.chiyi.leet.interview.algoritims;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySolutionTest {
    ArraySolution arraySolution;

    @Before
    public void setUp() throws Exception {
        arraySolution = new ArraySolution();
    }

    @Test
    public void removeDuplicates() {
        Assert.assertEquals(5, arraySolution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}