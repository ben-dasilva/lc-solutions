package training.wcontest.wc145;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> s2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        List<Integer> missing = new ArrayList<>();
        List<Integer> present = new ArrayList<>();

        Map<Integer, Integer> c = new HashMap<>();

        for (int original : arr1) {
            if (!s2.contains(original)) {
                missing.add(original);
                continue;
            }

            c.putIfAbsent(original, 0);
            c.computeIfPresent(original, (k, old) -> old + 1);
        }

        for (int ordered : arr2) {
            for (int i = 0; i < c.getOrDefault(ordered, 0); i++) {
                present.add(ordered);
            }
        }

        Collections.sort(missing);
        present.addAll(missing);

        return present.stream().mapToInt(i -> i).toArray();
    }
}