package training.leetcode.p_0000.p0008;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_0008Test {
    @Test
    public void ensure42works() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("42");

        assertEquals(42, i);
    }

    @Test
    public void ensure_negative_42_works() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("      -42");

        assertEquals(-42, i);
    }

    @Test
    public void ensure_4193_with_words_works() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("4193 with words");

        assertEquals(4193, i);
    }

    @Test
    public void ensure_words_and_987_works() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("words and 987");

        assertEquals(0, i);
    }

    @Test
    public void ensure_0_works() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("   0 ");

        assertEquals(0, i);
    }

    @Test
    public void ensure_0000_works() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("   00000 ");

        assertEquals(0, i);
    }

    @Test
    public void ensure_1_works() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("1");

        assertEquals(1, i);
    }

    @Test
    public void ensure_plus_1_works() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("+1");

        assertEquals(1, i);
    }

    @Test
    public void test_overflow() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("-91283472332");

        assertEquals(-2147483648, i);
    }

    @Test
    public void test_not_overflow() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("2147483646");

        assertEquals(2147483646, i);
    }

    @Test
    public void test_overflow2() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("2147483648");

        assertEquals(2147483647, i);
    }

    @Test
    public void test_overflow3() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("2147483647");

        assertEquals(2147483647, i);
    }

    @Test
    public void test_overflow4() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("-2147483649");

        assertEquals(-2147483648, i);
    }

    @Test
    public void test_overflow5() {
        Solution_0008 s = new Solution_0008();

        int i = s.myAtoi("-2147483647");

        assertEquals(-2147483647, i);
    }
}