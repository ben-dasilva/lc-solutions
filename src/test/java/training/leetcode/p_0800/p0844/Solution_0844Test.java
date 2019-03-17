package training.leetcode.p_0800.p0844;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_0844Test {
    // solution object
    Solution_0844 s = new Solution_0844();

    @Test
    public void ensure_it_works_when_input_is_a_single_char() {
        boolean result = s.backspaceCompare("a", "a");

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_blank() {
        boolean result = s.backspaceCompare("", "");

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_ab_c() {
        boolean result = s.backspaceCompare("ab#c", "ad#c");

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_ab__() {
        boolean result = s.backspaceCompare("ab##", "c#d#");

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_a__c() {
        boolean result = s.backspaceCompare("a##c", "#a#c");

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_a_c() {
        boolean result = s.backspaceCompare("a#c", "b");

        assertFalse(result);
    }

    @Test
    public void ensure_it_works_when_input_is_a_____________________b() {
        boolean result = s.backspaceCompare("a#################b", "a#b#c#d#b");

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_bxj__tw() {
        boolean result = s.backspaceCompare("bxj##tw", "bxo#j##tw");

        assertTrue(result);
    }
}