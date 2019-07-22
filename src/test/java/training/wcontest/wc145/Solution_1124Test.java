package training.wcontest.wc145;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Solution_1124Test {
    // solution object
    private Solution_1124 s = new Solution_1124();

    @Test
    public void ensure_it_works_when_input_is_1() {
        int result = s.longestWPI(new int[]{9, 9, 9, 6, 0, 6, 6, 9});

        assertThat(result, is(3));
    }
}