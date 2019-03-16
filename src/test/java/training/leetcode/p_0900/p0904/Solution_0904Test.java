package training.leetcode.p_0900.p0904;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_0904Test {
    Solution_0904 solution = new Solution_0904();

    @Test
    public void ensure_1_works() {
        int fruits = solution.totalFruit(new int[]{1});

        assertEquals(1, fruits);
    }

    @Test
    public void ensure_empty_list_works() {
        int fruits = solution.totalFruit(new int[]{});

        assertEquals(0, fruits);
    }

    @Test
    public void ensure_1_1_1_1_1_1_works() {
        int fruits = solution.totalFruit(new int[]{1, 1, 1, 1, 1, 1});

        assertEquals(6, fruits);
    }

    @Test
    public void ensure_1_2_1_2_1_2_works() {
        int fruits = solution.totalFruit(new int[]{1, 2, 1, 2, 1, 2});

        assertEquals(6, fruits);
    }

    @Test
    public void ensure_1_2_3_1_2_1_2_works() {
        int fruits = solution.totalFruit(new int[]{1, 2, 3, 1, 2, 1, 2});

        assertEquals(4, fruits);
    }

    @Test
    public void ensure_0_0_1_1_works() {
        int fruits = solution.totalFruit(new int[]{0, 0, 1, 1});

        assertEquals(4, fruits);
    }

    // [0,1,6,6,4,4,6]
    @Test
    public void ensure_0_1_6_6_4_4_6_works() {
        int fruits = solution.totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6});

        assertEquals(5, fruits);
    }

    // 1,0,1,4,1,4,1,2,3
    @Test
    public void ensure_1_0_1_4_1_4_1_2_3_works() {
        int fruits = solution.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3});

        assertEquals(5, fruits);
    }
}