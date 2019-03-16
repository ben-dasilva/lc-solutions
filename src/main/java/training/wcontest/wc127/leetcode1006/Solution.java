package training.wcontest.wc127.leetcode1006;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Solution {
    public int clumsy(int N) {
        List<BiFunction<Integer, Integer, Integer>> ops = Arrays.asList(
                (Integer a, Integer b) -> a * b,
                (Integer a, Integer b) -> a / b,
                (Integer a, Integer b) -> a + b,
                (Integer a, Integer b) -> a - b
        );

        int total = N;
        int c = 0;

        for (int i = N-1; i > 0; i--) {
            total = ops.get(c % 4).apply(total, i);
            c++;
        }

        return total;
    }
}
