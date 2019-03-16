package training.leetcode.p_0000.p0009;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_0009Test {
    Solution_0009 solution = new Solution_0009();

    @Test
    public void test121() {

        assertTrue(solution.isPalindrome(121));
    }

    @Test
    public void test122() {
        assertFalse(solution.isPalindrome(122));
    }

    @Test
    public void test_0() {
        assertTrue(solution.isPalindrome(0));
    }

    @Test
    public void test_1() {
        assertTrue(solution.isPalindrome(1));
    }

    @Test
    public void test10() {
        assertFalse(solution.isPalindrome(10));
    }

    @Test
    public void test_negative_121() {
        assertFalse(solution.isPalindrome(-121));
    }

    @Test
    public void test_2147483647() {
        assertFalse(solution.isPalindrome(2147483647));
    }
}