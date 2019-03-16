package training.wcontest.wc127.leetcode1005;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Solution_1005Test {
    @Test
    public void test423is5() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{4, 2, 3}, 1);

        assertEquals(5, i);
    }

    @Test
    public void test423is6() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{3,-1,0,2}, 3);

        assertEquals(6, i);
    }

    @Test
    public void test423is13() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2);

        assertEquals(13, i);
    }

    @Test
    public void testAllNegative() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{-1, -2, -3, -4, -5}, 2);

        assertEquals(3, i);
    }

    @Test
    public void testAllPositive() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{1, 2, 3, 4, 5}, 200);

        assertEquals(15, i);
    }

    @Test
    public void testTwoNegativesSameNumber() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{-10, -10, 2}, 2);

        assertEquals(22, i);
    }

    @Test
    public void testSinglePositiveNumber() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{2}, 2);

        assertEquals(2, i);
    }

    @Test
    public void testSinglePositiveNumber2() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{2}, 1);

        assertEquals(-2, i);
    }

    @Test
    public void firstContestFailed() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{-2,5,0,2,-2}, 3);

        assertEquals(11, i);
    }

    @Test
    public void firstContestFailed2() {
        Solution solution = new Solution();
        int i = solution.largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2}, 6);

        assertEquals(22, i);
    }
}