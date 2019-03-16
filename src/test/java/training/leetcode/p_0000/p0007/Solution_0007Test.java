package training.leetcode.p_0000.p0007;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_0007Test {
    Solution_0007 s = new Solution_0007();

    @Test
    public void test_123() {
        int reversed = s.reverse(123);

        assertEquals(321, reversed);
    }

    @Test
    public void test_negative_123() {
        int reversed = s.reverse(-123);

        assertEquals(-321, reversed);
    }

    @Test
    public void test_1() {
        int reversed = s.reverse(1);

        assertEquals(1, reversed);
    }

    @Test
    public void test_negative_1() {
        int reversed = s.reverse(-1);

        assertEquals(-1, reversed);
    }

    @Test
    public void test_overflow() {
        int reversed = s.reverse(1463847419);

        assertEquals(0, reversed);
    }

    @Test
    public void test_not_overflow() {
        int reversed = s.reverse(-2147483412);

        assertEquals(-2143847412, reversed);
    }
}