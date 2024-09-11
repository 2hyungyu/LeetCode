package org.example;

import java.io.CharArrayReader;
import java.util.*;

public class StringLeetCode {
    public void reverseString(char[] s) {
        int sPos = 0;
        int ePos = s.length - 1;
        while (sPos < ePos) {
            char temp = s[sPos];
            s[sPos] = s[ePos];
            s[ePos] = temp;
            sPos++;
            ePos--;
        }
    }

    public int reverse(int x) {
        int reversedNum = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));
        sb.reverse();
        try {
            if (x < 0) {
                reversedNum = -1 * Integer.parseInt(sb.toString());
            } else {
                reversedNum = Integer.parseInt(sb.toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }

        return reversedNum;
    }

    public int firstUniqChar(String s) {
        for (int i = 0 ; i < s.length() ; i++) {
            char curChar = s.charAt(i);
            if (s.indexOf(curChar) == s.lastIndexOf(curChar)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isAnagram(String s, String t) {
       Map<Character, Integer> charMap = new HashMap<>();
       for (char ch : s.toCharArray()) {
           charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
       }
       for (char ch : t.toCharArray()) {
           charMap.put(ch, charMap.getOrDefault(ch, 0) - 1);
       }
       for (Map.Entry<Character, Integer> entry: charMap.entrySet()) {
           if (entry.getValue() != 0) {
               return false;
           }
       }
       return true;
    }

    public boolean isPalindrome(String s) {
        int sPos = 0;
        int ePos = s.length() - 1;

        while (sPos < ePos) {
            char charAtSPos = s.charAt(sPos);
            char charAtEPos = s.charAt(ePos);
            if (!Character.isLetterOrDigit(charAtSPos)) {
                sPos++;
            } else if (!Character.isLetterOrDigit(charAtEPos)) {
                ePos--;
            } else {
                if  (Character.toLowerCase(charAtSPos) != Character.toLowerCase(charAtEPos)) {
                    return false;
                }
                sPos++;
                ePos--;
            }
        }
        return true;
    }

    /**
     * Whitespace: Ignore any leading whitespace (" ").
     * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
     * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
     * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1
     */
    public int myAtoi(String s) {
        if (s.isBlank()) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int curIndex = 0;
        s = s.trim();
        // find the first digit character index
        char curChar = s.charAt(0);
        boolean isNegative = false;
        if (!Character.isDigit(curChar) && curChar != '-' && curChar != '+') {
            return 0;
        } else if (curChar == '-') {
            isNegative = true;
            curIndex++;
        } else if (curChar == '+') {
            curIndex++;
        }

        while (curIndex < s.length()) {
            curChar = s.charAt(curIndex);
            if (!Character.isDigit(curChar)) {
                break;
            }
            sb.append(s.charAt(curIndex));
            curIndex++;
        }

        if (sb.isEmpty()) {
            return 0;
        }

        if (isNegative) {
            sb.insert(0, '-');
        }

        int result;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return result;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        StringBuilder result = new StringBuilder();
        int minLength = Math.min(strs[0].length(), strs[strs.length - 1].length());
        String firstStr = strs[0];
        String lastStr = strs[strs.length - 1];
        for (int curIndex = 0 ; curIndex < minLength ; curIndex++) {
            if (firstStr.charAt(curIndex) != lastStr.charAt(curIndex)) {
                return result.toString();
            }
            result.append(firstStr.charAt(curIndex));
        }
        return result.toString();
    }
}
