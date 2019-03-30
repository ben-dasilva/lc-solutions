package training.wcontest.wc129;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_1022Test {
    // solution object
    Solution_1022 s = new Solution_1022();

    @Test
    public void ensure_it_works_when_input_is_1() {
        int result = s.smallestRepunitDivByK(1);

        assertEquals(1, result);
    }

    @Test
    public void ensure_it_works_when_input_is_2() {
        int result = s.smallestRepunitDivByK(2);

        assertEquals(-1, result);
    }

    @Test
    public void ensure_it_works_when_input_is_3() {
        int result = s.smallestRepunitDivByK(3);

        assertEquals(3, result);
    }

    @Test
    public void ensure_it_works_when_input_is_max() {
        int result = s.smallestRepunitDivByK(17);

        assertEquals(16, result);
    }

    @Test
    public void ensure_it_works_when_input_is_23() {
        int result = s.smallestRepunitDivByK(23);

        assertEquals(22, result);
    }

    @Test
    public void ensure_it_works_when_input_is_5367() {
        int result = s.smallestRepunitDivByK(5367);

        assertEquals(1788, result);
    }
}