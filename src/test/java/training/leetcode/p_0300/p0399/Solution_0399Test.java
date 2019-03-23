package training.leetcode.p_0300.p0399;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_0399Test {
    // solution object
    Solution_0399 s = new Solution_0399();

    @Test
    public void ensure_it_works_when_input_is_a_div_a() {
        double[] result = s.calcEquation(new String[][] {{"a", "b"}}, new double[] { 2.0, 3.0 }, new String[][] {{"a", "a"}});

        assertArrayEquals(new double[] {1.0}, result, 0.001);
    }

    @Test
    public void ensure_it_works_when_input_is_a_div_b() {
        double[] result = s.calcEquation(new String[][] {{"a", "b"}}, new double[] { 2.0, 3.0 }, new String[][] {{"a", "b"}});

        assertArrayEquals(new double[] {2.0}, result, 0.001);
    }

    @Test
    public void ensure_it_works_when_input_is_b_div_a() {
        double[] result = s.calcEquation(new String[][] {{"a", "b"}}, new double[] { 2.0, 3.0 }, new String[][] {{"b", "a"}});

        assertArrayEquals(new double[] {0.5}, result, 0.001);
    }

    @Test
    public void ensure_it_works_when_input_is_a_div_c() {
        double[] result = s.calcEquation(new String[][] {{"a", "b"}, {"b", "c"}}, new double[] { 2.0, 3.0 }, new String[][] {{"a", "c"}});

        assertArrayEquals(new double[] {6}, result, 0.001);
    }

    @Test
    public void ensure_it_works_when_input_is_a_div_b_div_c_etc() {
        double[] result = s.calcEquation(new String[][] {
                {"a", "b"},
                {"b", "c"},
                {"c", "d"},
                {"d", "e"},
                {"e", "f"},
                }, new double[] { 2.0, 3.0 , 1.0, 2.0, 1.0}, new String[][] {{"a", "f"}});

        assertArrayEquals(new double[] {12}, result, 0.001);
    }

    @Test
    public void ensure_it_works_when_input_is_reverse_of_a_div_b_div_c_etc() {
        double[] result = s.calcEquation(new String[][] {
                {"a", "b"},
                {"b", "c"},
                {"c", "d"},
                {"d", "e"},
                {"e", "f"},
                }, new double[] { 2.0, 3.0 , 1.0, 2.0, 1.0}, new String[][] {{"f", "a"}});

        assertArrayEquals(new double[] {1/12.0}, result, 0.001);
    }

    @Test
    public void ensure_it_works_when_input_is_a_div_c_and_others() {
        double[] result = s.calcEquation(new String[][] {{"a", "b"}, {"b", "c"}}, new double[] { 2.0, 3.0 },
                new String[][] {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x}"}});

        assertArrayEquals(new double[] {6, 0.5, -1.0, 1.0, -1.0}, result, 0.001);
    }
}