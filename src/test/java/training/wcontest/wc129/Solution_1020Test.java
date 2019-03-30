package training.wcontest.wc129;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_1020Test {
    // solution object
    Solution_1020 s = new Solution_1020();

    @Test
    public void ensure_it_works_when_input_is_0_2_1_negative_6_6___1() {
        boolean result = s.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1});

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_0_2_1_negative_6_6___1_false() {
        boolean result = s.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1});

        assertFalse(result);
    }

    @Test
    public void ensure_it_works_when_input_is_3_3_etc() {
        boolean result = s.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4});

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_1_1_1_1_etc() {
        boolean result = s.canThreePartsEqualSum(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1});

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_1_10_1_1_etc() {
        boolean result = s.canThreePartsEqualSum(new int[]{1, 10, -10, 1, 10, -10, 10, -10, 1});

        assertTrue(result);
    }

    @Test
    public void ensure_it_works_when_input_is_18_10_1_1_etc() {
        boolean result = s.canThreePartsEqualSum(new int[]{18, 12, -18, 18, -19, -1, 10, 10});

        assertTrue(result);
    }
}