package training.leetcode.p_0400.p0482;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution_0482Test {
    // solution object
    Solution_0482 s = new Solution_0482();

    @Test
    public void ensure_it_works_when_input_is_5F3Z() {
        String result = s.licenseKeyFormatting("5F3Z-2e-9-w", 4);

        assertEquals("5F3Z-2E9W", result);
    }

    @Test
    public void ensure_it_works_when_input_is_2_5g() {
        String result = s.licenseKeyFormatting("2-5g-3-J", 2);

        assertEquals("2-5G-3J", result);
    }

    @Test
    public void ensure_it_works_when_input_is_blank() {
        String result = s.licenseKeyFormatting("", 5);

        assertEquals("", result);
    }

    @Test
    public void ensure_it_works_when_input_is_single_char() {
        String result = s.licenseKeyFormatting("a", 5);

        assertEquals("A", result);
    }
}