package training.leetcode.p_0000.p0006;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_0006Test {
    Solution_0006 solution = new Solution_0006();

    @Test
    public void ensurePayPalStingWorksWith3Rows() {
        String encoded = solution.convert("PAYPALISHIRING", 3);

        assertEquals("PAHNAPLSIIGYIR", encoded);
    }

    @Test
    public void ensurePayPalStingWorksWith1Row() {
        String encoded = solution.convert("PAYPALISHIRING", 1);

        assertEquals("PAYPALISHIRING", encoded);
    }

    @Test
    public void ensurePayPalStingWorksWith2Rows() {
        String encoded = solution.convert("PAYPALISHIRING", 2);

        assertEquals("PYAIHRNAPLSIIG", encoded);
    }

    @Test
    public void ensurePayPalStingWorksWith4Rows() {
        String encoded = solution.convert("PAYPALISHIRING", 4);

        assertEquals("PINALSIGYAHRPI", encoded);
    }

    @Test
    public void ensure_single_letter_works() {
        String encoded = solution.convert("P", 4);

        assertEquals("P", encoded);
    }

    @Test
    public void ensure_empty_string_works() {
        String encoded = solution.convert("", 4);

        assertEquals("", encoded);
    }

    @Test
    public void ensure_2_letters_work() {
        String encoded = solution.convert("AB", 4);

        assertEquals("AB", encoded);
    }
}