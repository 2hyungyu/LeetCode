package org.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class OthersLeetCode {
    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }

    public int hammingDistance(int x, int y) {
        int diff = 0;
        int xor = x ^ y;
        while (xor != 0) {
            diff = diff + (xor & 1);
            xor = xor >>> 1;
        }
        return diff;
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0 ; i < 32 ; i++) {
            result <<= 1;
            result = result + (n & 1);
            n >>= 1;
        }
        return result;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if (numRows == 1) {
            return result;
        }

        int rowPos = 1;
        while (rowPos < numRows) {
            List<Integer> row = new ArrayList<>();
            List<Integer> previousRow = result.get(rowPos - 1);
            int colPos = 0;
            while (colPos <= rowPos) {
                if (colPos == 0 || colPos == rowPos) {
                    row.add(1);
                } else {
                    row.add(previousRow.get(colPos - 1) + previousRow.get(colPos));
                }
                colPos++;
            }
            result.add(row);
            rowPos++;
        }
        return result;
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty()){
                char peek = stack.peek();
                if ((peek == '{' && ch == '}') || (peek == '[' && ch == ']') || (peek == '(' && ch == ')')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1 ; i < nums.length ; i++) {
            int num = nums[i];
            int previousNum = nums[i - 1];
            if (num != previousNum + 1) {
                return previousNum + 1;
            }
        }
        return nums.length;
    }
}
