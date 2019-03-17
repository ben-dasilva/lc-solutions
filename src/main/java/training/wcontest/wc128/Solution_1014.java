package training.wcontest.wc128;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_1014 {
    public int shipWithinDays(int[] weights, int D) {
        int totalWeight = Arrays.stream(weights).sum();
        int maxWeight = Arrays.stream(weights).max().orElse(0);
        int minShipSize = totalWeight / D;

        for (int i = Math.max(minShipSize, maxWeight); i <= totalWeight; i++) {
            int days = tryToSplitUsing(weights, i);
            if (days <= D) return i;
        }

        return 1;
    }

    private int tryToSplitUsing(int[] weights, int shipSize) {
        int c = 0;
        int days = 0;

        List<Integer> ship = new LinkedList<>();

        for (int i = 0; i < weights.length; i++) {
            c += weights[i];

            if (c < shipSize) {
                ship.add(weights[i]);
                continue;
            }

            if (c > shipSize) i--;

            ship = new LinkedList<>();

            c = 0;

            days++;
        }

        if (c > 0) days++;

        return days;
    }
}
