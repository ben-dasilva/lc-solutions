package training.wcontest.wc128;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_1012Test {
    // solution object
    Solution_1012 s = new Solution_1012();

    @Test
    public void ensure_it_works_when_input_is_0() {
        int result = s.bitwiseComplement(0);

        assertEquals(1, result);
    }

    @Test
    public void ensure_it_works_when_input_is_2() {
        int result = s.bitwiseComplement(2);

        assertEquals(1, result);
    }

    @Test
    public void ensure_it_works_when_input_is_5() {
        int result = s.bitwiseComplement(5);

        assertEquals(2, result);
    }

    @Test
    public void ensure_it_works_when_input_is_7() {
        int result = s.bitwiseComplement(7);

        assertEquals(0, result);
    }

    @Test
    public void ensure_it_works_when_input_is_10() {
        int result = s.bitwiseComplement(10);

        assertEquals(5, result);
    }

    @Test
    public void ensure_it_works_when_input_is_999999999() {
        int result = s.bitwiseComplement(999999999);

        assertEquals(73741824, result);
    }

}