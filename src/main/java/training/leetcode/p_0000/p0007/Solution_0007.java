package training.leetcode.p_0000.p0007;

public class Solution_0007 {
    private static final int MIN_DELTA = Integer.MAX_VALUE - Integer.MAX_VALUE / 10;

    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            if (Integer.MAX_VALUE - Math.abs(result) < MIN_DELTA) return 0;

            result *= 10;
            result += x % 10;
            x /= 10;
        }

        return result;
    }
}
