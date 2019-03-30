package training.leetcode.p_0900.p0947;

import org.junit.Test;
import training.leetcode.p_0900.p0947.provided.ProvidedSolution_0947;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Solution_0947Test {
    // solution object
    private Solution_0947 s = new ProvidedSolution_0947();

    @Test
    public void ensure_it_works_when_input_is_example_1() {
        int result = s.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}});

        assertThat(result, is(5));
    }

    @Test
    public void ensure_it_works_when_input_is_example_2() {
        int result = s.removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}});

        assertThat(result, is(3));
    }

    @Test
    public void ensure_it_works_when_input_is_example_3() {
        int result = s.removeStones(new int[][]{{0, 0}});

        assertThat(result, is(0));
    }

    @Test
    public void ensure_it_works_when_input_is_example_5_failed() {
        int result = s.removeStones(new int[][]{
                {5, 9}, {9, 0}, {0, 0}, {7, 0}, {4, 3}, {8, 5}, {5, 8},
                {1, 1}, {0, 6}, {7, 5}, {1, 6}, {1, 9}, {9, 4}, {2, 8},
                {1, 3}, {4, 2}, {2, 5}, {4, 1}, {0, 2}, {6, 5}});

        assertThat(result, is(19));
    }
}