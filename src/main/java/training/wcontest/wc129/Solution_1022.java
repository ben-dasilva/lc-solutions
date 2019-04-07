package training.wcontest.wc129;

public class Solution_1022 {
    public int smallestRepunitDivByK(int K) {
        long max = 1;

        if (K % 2 == 0) return -1;
        if (K % 5 == 0) return -1;

        int len = 0;

        for (int i = 0; i < 1_000_000; i++) {
            if (max % K == 0) return i + 1;

            long old1 = max;
            max = max * 10 + 1;
            long old2 = max;
            max %= K;
            System.out.printf("> K: %d, max: %4d --x10+1-> %4d  --mod-> %4d\n", K, old1, old2, max);
        }

        return -1;
    }
}
