package org.LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringLeetCodeTest {
    @Test
    void reverseStringTest() {
        StringLeetCode stringLeetCode = new StringLeetCode();
        char[] reverseString = new char[]{'s', 'a', 'o', 'p', 's'};
        stringLeetCode.reverseString(reverseString);
        assertArrayEquals(reverseString, new char[]{'s', 'p', 'o', 'a', 's'});
    }

    @Test
    void reverseIntTest() {
        StringLeetCode stringLeetCode = new StringLeetCode();
        assertEquals(123, stringLeetCode.reverse(321));
        assertEquals(0, stringLeetCode.reverse(1534236469));
    }

    @Test
    void firstUniqCharTest() {
        StringLeetCode stringLeetCode = new StringLeetCode();
        assertEquals(2, stringLeetCode.firstUniqChar( "loveleetcode"));
        assertEquals(-1, stringLeetCode.firstUniqChar("aabb"));
    }

    @Test
    void isAnagramTest() {
        StringLeetCode stringLeetCode = new StringLeetCode();
        assertTrue(stringLeetCode.isAnagram("anagram", "nagaram"));
        assertFalse(stringLeetCode.isAnagram("rat", "car"));
    }

    @Test
    void isPalindromeTest() {
        StringLeetCode stringLeetCode = new StringLeetCode();
        assertTrue(stringLeetCode.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(stringLeetCode.isPalindrome("race a car"));
        assertTrue(stringLeetCode.isPalindrome(" "));
        assertFalse(stringLeetCode.isPalindrome("0P"));
    }

    @Test
    void myAtoiTest() {
        StringLeetCode stringLeetCode = new StringLeetCode();
        assertEquals(42, stringLeetCode.myAtoi("42"));
        assertEquals(-42, stringLeetCode.myAtoi("   -042"));
    }
}
