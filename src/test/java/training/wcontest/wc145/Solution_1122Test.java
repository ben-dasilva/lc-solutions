package training.wcontest.wc145;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Solution_1122Test {
    // solution object
    private Solution_1122 s = new Solution_1122();

    @Test
    public void ensure_it_works_when_input_is_1() {
        int[] result = s.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6});

        assertThat(result, is(new int[]{22, 28, 8, 6, 17, 44}));
    }
}