package org.example;

import java.util.Arrays;

public class Array {
    public int removeDuplicates(int[] nums) {
        int curIndex = 1;
        int curInt = nums[0];
        for (int index = 1 ; index < nums.length ; index++) {
            int newInt = nums[index];
            if (curInt != newInt) {
                nums[curIndex] = newInt;
                curInt = newInt;
                curIndex++;
            }
        }
        return curIndex;
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] numsCopy = nums.clone();
        int rotate = Math.abs(k - nums.length);
        int endIndex = 0;
        for (int index = 0 ; index < nums.length ; index++) {
            if (rotate < nums.length) {
                nums[index] = numsCopy[rotate];
                rotate++;
            } else {
                nums[index] = numsCopy[endIndex];
                endIndex++;
            }
        }
    }
}
