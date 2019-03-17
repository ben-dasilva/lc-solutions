package training.wcontest.wc128;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_1013Test {
    // solution object
    Solution_1013 s = new Solution_1013();

    @Test
    public void ensure_it_works_when_input_is_30_40() {
        int result = s.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});

        assertEquals(3, result);
    }

    @Test
    public void ensure_it_works_when_input_is_60_60() {
        int result = s.numPairsDivisibleBy60(new int[]{60, 60, 60});

        assertEquals(3, result);
    }

    @Test
    public void ensure_it_works_when_input_is_60() {
        int result = s.numPairsDivisibleBy60(new int[]{60});

        assertEquals(0, result);
    }

    @Test
    public void ensure_it_works_when_input_is_20() {
        int result = s.numPairsDivisibleBy60(new int[]{20});

        assertEquals(0, result);
    }

    @Test
    public void ensure_it_works_when_input_is_30() {
        int result = s.numPairsDivisibleBy60(new int[]{30});

        assertEquals(0, result);
    }

    @Test
    public void ensure_it_works_when_input_is_30_30() {
        int result = s.numPairsDivisibleBy60(new int[]{30, 30});

        assertEquals(1, result);
    }

    @Test
    public void ensure_it_works_when_input_is_empty() {
        int result = s.numPairsDivisibleBy60(new int[]{});

        assertEquals(0, result);
    }

    @Test
    public void ensure_it_works_when_input_is_2() {
        int result = s.numPairsDivisibleBy60(new int[]{15, 63, 451, 213, 37, 209, 343, 319});

        assertEquals(1, result);
    }
}