package training.leetcode.p_0000.p0005;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_0005Test {
    @Test
    public void ensure_abc123321cba_is_found() {
        Solution_0005 solution = new Solution_0005();

        String longestPalindrome = solution.longestPalindrome("912837912837abc123321cba13412413809");

        assertEquals("abc123321cba", longestPalindrome);
    }

    @Test
    public void ensure_bb_is_found() {
        Solution_0005 solution = new Solution_0005();

        String longestPalindrome = solution.longestPalindrome("cbbd");

        assertEquals("bb", longestPalindrome);
    }

    @Test
    public void ensure_a_is_found() {
        Solution_0005 solution = new Solution_0005();

        String longestPalindrome = solution.longestPalindrome("a");

        assertEquals("a", longestPalindrome);
    }

    @Test
    public void ensure_a_is_found_in_ac() {
        Solution_0005 solution = new Solution_0005();

        String longestPalindrome = solution.longestPalindrome("ac");

        assertEquals("a", longestPalindrome);
    }

    @Test
    public void ensure_empty_string_returns_empty_string() {
        Solution_0005 solution = new Solution_0005();

        String longestPalindrome = solution.longestPalindrome("");

        assertEquals("", longestPalindrome);
    }

    @Test
    public void ensure_bb_is_palindrome() {
        Solution_0005 solution = new Solution_0005();

        String longestPalindrome = solution.longestPalindrome("bb");

        assertEquals("bb", longestPalindrome);
    }

    @Test
    public void ensure_aaabaaa_is_found_in_aaabaaaa() {
        Solution_0005 solution = new Solution_0005();

        String longestPalindrome = solution.longestPalindrome("aaabaaaa");

        assertEquals("aaabaaa", longestPalindrome);
    }
}