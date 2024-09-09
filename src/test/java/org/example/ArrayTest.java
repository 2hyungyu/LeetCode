package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest {
    @Test
    void intersectTest() {
        Array array = new Array();
        int[] intersect = array.intersect(new int[]{1,2,2,1}, new int[]{2,2});
        assertArrayEquals(intersect, new int[]{2,2});
    }

    @Test
    void plusOneTest() {
        Array array = new Array();
        int[] plusOne = array.plusOne(new int[]{9,9,9});
        assertArrayEquals(plusOne, new int[]{1,0,0,0});

        plusOne = array.plusOne(new int[]{1,2,3});
        assertArrayEquals(plusOne, new int[]{1,2,4});
    }

    @Test
    void moveZerosTest() {
        Array array = new Array();
        int[] moveZero = new int[]{0,5,2,0,1};
        array.moveZeroes(moveZero);
        assertArrayEquals(moveZero, new int[]{5,2,1,0,0});
    }

    @Test
    void twoSumTest() {
        Array array = new Array();
        int[] twoSum = array.twoSum(new int[]{2,7,11,15}, 9);
        assertArrayEquals(twoSum, new int[]{0, 1});

        twoSum = array.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(twoSum, new int[]{1, 2});
    }
}
