package org.LeetCode;

import java.util.*;

public class ArrayLeetCode {
    public int removeDuplicates(int[] nums) {
        int curIndex = 1;
        int curInt = nums[0];
        for (int index = 1; index < nums.length; index++) {
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
        int length = nums.length;
        k = k % nums.length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int sPos, int ePos) {
        while (sPos < ePos) {
            int temp = nums[sPos];
            nums[sPos] = nums[ePos];
            nums[ePos] = temp;
            sPos++;
            ePos--;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        Set<Integer> detectDup = new HashSet<>();
        for (int num : nums) {
            if (!detectDup.add(num)) {
                return true;
            }
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) {
            throw new IllegalArgumentException();
        }
        int singleNum = nums[0];
        for (int i = 1; i < length; i++) {
            singleNum = singleNum ^ nums[i];
        }
        return singleNum;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums1Index = 0;
        int nums2Index = 0;
        List<Integer> intersectList = new ArrayList<>();
        while (nums1Index < nums1.length && nums2Index < nums2.length) {
            int num1 = nums1[nums1Index];
            int num2 = nums2[nums2Index];
            if (num1 < num2) {
                nums1Index++;
            } else if (num1 > num2) {
                nums2Index++;
            } else {
                nums1Index++;
                nums2Index++;
                intersectList.add(num1);
            }
        }
        int[] intersectArray = new int[intersectList.size()];
        for (int i = 0; i < intersectList.size(); i++) {
            intersectArray[i] = intersectList.get(i);
        }
        return intersectArray;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] plusOne = new int[digits.length + 1];
        plusOne[0] = 1;
        return plusOne;
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap= new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int remain = target - nums[i];
            if (numMap.containsKey(remain)) {
                return new int[]{numMap.get(remain), i};
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - sumMap.get(sum - k));
            }
            sumMap.put(sum, i);
        }

        return maxLength;
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
