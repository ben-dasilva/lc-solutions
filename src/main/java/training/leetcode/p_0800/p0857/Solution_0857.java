package training.leetcode.p_0800.p0857;

import java.util.*;

/**
 * <h3> LC-0857: Minimum Cost to Hire K Workers </h3>
 */
public class Solution_0857 {
    private double[][] costOf(int[] quality, int[] wage) {
        double[][] cost = new double[quality.length][2];

        for (int i = 0; i < quality.length; i++) {
            cost[i][0] = wage[i]/(double)quality[i];
            cost[i][1] = i;
        }

        // lowest cost (wage/quality) first
        Arrays.sort(cost, Comparator.comparingDouble(a -> a[0]));

        return cost;
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        // 1. first ordering, sort by VALUE, DESCENDING
        // 2. second ordering, sort by QUALITY, ASCENDING

        if (K > quality.length) return -1;

        double[][] cost = costOf(quality, wage);

        PriorityQueue<Integer> candidates = buildCandidates(quality, K, cost);

        int sum = getSum(candidates);

        double lowest = sum * cost[K - 1][0];

        int lastQ = -candidates.peek();

        for (int i = K; i < quality.length; i++) {
            int thisQ = quality[(int) cost[i][1]];

            if (thisQ >= lastQ) continue;

            candidates.remove();
            candidates.add(-thisQ);
            sum -= lastQ - thisQ;
            lastQ = -candidates.peek();
            double thisTotal = sum * cost[i][0];

            if (thisTotal < lowest) lowest = thisTotal;
        }

        return lowest;
    }

    private int getSum(PriorityQueue<Integer> candidates) {
        int sum = 0;

        for (int c : candidates) {
            sum += -c;
        }

        return sum;
    }

    private PriorityQueue<Integer> buildCandidates(int[] quality, int K, double[][] cost) {
        PriorityQueue<Integer> candidates = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            candidates.add(-quality[(int) cost[i][1]]);
        }

        return candidates;
    }
}
