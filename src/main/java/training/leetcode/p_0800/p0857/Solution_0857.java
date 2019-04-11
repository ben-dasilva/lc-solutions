package training.leetcode.p_0800.p0857;

import java.util.*;

/**
 * <h3> LC-0857: Minimum Cost to Hire K Workers </h3>
 */
public class Solution_0857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        long start = System.currentTimeMillis();

        TreeMap<Double, List<Integer>> groups = buildSortedValueGroups(quality, wage);

        double[] value = groups.keySet().stream().mapToDouble(e -> e).sorted().toArray();

        // groups.forEach((k, v) -> System.out.printf("[%4.2f]: %s\n", k, v));
        int[][] g = new int[value.length][];

        int wc = 0;

        long end2 = System.currentTimeMillis();
        System.out.println("BUILT GROUPS: " + (end2 - start) + ", length: " + groups.size());

        start = end2;

        for (List<Integer> w : groups.values()) {
            g[wc++] = w.stream().mapToInt(e -> e).toArray();
        }

        end2 = System.currentTimeMillis();
        System.out.println("BUILT G ARRAY: " + (end2 - start));

        start = end2;

        double theMin = Double.MAX_VALUE;

        boolean[] mayUse = new boolean[wage.length];

        for (int i = groups.size() - 1; i >= 0; i--) {
            for (int j = groups.size() - 1; j >= i; j--) {
                double thisMin = calculateMinCost(g, wage, quality, value, j, K, theMin, mayUse);

                if (thisMin == -1) continue;

                if (thisMin < theMin) { theMin = thisMin; }
            }

            long end = System.currentTimeMillis();
            System.out.printf("[%d..%d]: %4.2f (%d)\n", i, groups.size(), theMin == Double.MAX_VALUE ? -1 : theMin, end - start);
            start = end;
        }

        System.out.println("mayUse = " + Arrays.toString(mayUse));
        return theMin == Double.MAX_VALUE ? -1 : theMin;
    }

    private double calculateMinCost(int[][] g, int[] wage, int[] quality, double[] value, int base, int k, double theMin, boolean[] mayUse) {
        int[] pointers = new int[g.length];

        double total = 0;

        while (k > 0) {
            double nextMin = Double.MAX_VALUE;
            int index = -1;

            for (int i = base; i < g.length; i++) {
                int p = pointers[i];

                if (p >= g[i].length) continue;

                double v = value[base];

                int nextPos = g[i][p];

                double candidate;
                if (i == base) {
                    // all elements may be used
                    candidate = wage[nextPos];
                } else {
                    // only previously known elements can be used
                    if (!mayUse[nextPos]) continue;

                    candidate = Math.max(quality[nextPos] / v, wage[nextPos]);
                }

                if (candidate < nextMin) {
                    nextMin = candidate;
                    index = i;
                    mayUse[nextPos] = true;
                }
            }

            if (index == -1) {
                System.out.printf("We don't have enough workers (%d..%d)\n", base, g.length);
                return -1;
            }

            total += nextMin;
            pointers[index]++;
            k--;

            if (total >= theMin) {
                System.out.printf("Total %4.2f exceeded the min %4.2f\n", total, theMin);
                return -1;
            }
        }

        return total;
    }

    private TreeMap<Double, List<Integer>> buildSortedValueGroups(int[] quality, int[] wage) {
        TreeMap<Double, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < wage.length; i++) {
            double value = quality[i] / (double) wage[i];
            map.putIfAbsent(value, new ArrayList<>());
            map.get(value).add(i);
        }

        for (List<Integer> value : map.values()) {
            value.sort(Comparator.comparingInt(v -> v));
        }

        return map;
    }
}
