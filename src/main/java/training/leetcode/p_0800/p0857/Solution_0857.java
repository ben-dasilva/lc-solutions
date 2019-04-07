package training.leetcode.p_0800.p0857;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <h3> LC-0857: Minimum Cost to Hire K Workers </h3>
 */
public class Solution_0857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        return 0;
    }

    Map<Double, List<Integer>> buildSortedValueGroups(int[] quality, int[] wage) {
        TreeMap<Double, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < wage.length; i++) {
            double value = quality[i] / wage[i];
            map.putIfAbsent(value, new ArrayList<>());
            map.get(value).add(i);
        }

        return map;
    }

    List<Integer> findMinimalCostWorkers(Map<Double, List<Integer>> vg, int[] wage) {
        return null;
    }
}
