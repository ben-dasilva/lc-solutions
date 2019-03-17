package training.wcontest.wc128;

import java.util.*;

public class Solution_1013 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, List<Integer>> numMap = new HashMap<>();

        for (int i = 0; i < time.length; i++) {
            int slot = time[i] % 60;

            int newValue = i;

            numMap.merge(slot, new ArrayList<>(Collections.singleton(i)), (oldV, newV) -> {
                oldV.add(newValue);
                return oldV;
            });
        }

        int matches = 0;

        for (int i = 1; i <= 29; i++) {
            List<Integer> low  = numMap.get(i);
            List<Integer> high = numMap.get(60 - i);

            if (low != null && high != null) {
                matches += low.size() * high.size();
            }
        }

        List<Integer> zero = numMap.get(0);
        List<Integer> thirty = numMap.get(30);
        matches += zero == null ? 0 : (zero.size() * (zero.size()-1))/2;
        matches += thirty == null ? 0 : (thirty.size() * (thirty.size()-1))/2;

        return matches;
    }
}
