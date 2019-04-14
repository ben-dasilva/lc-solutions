package training.leetcode.p_0800.p0857;

import java.util.*;

/**
 * <h3> LC-0857: Minimum Cost to Hire K Workers </h3>
 */
public class Solution_0857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        double ans = 1e9;

        for (int captain = 0; captain < N; ++captain) {
            // Must pay at least wage[captain] / quality[captain] per qual
            double factor = (double) wage[captain] / quality[captain];
            double prices[] = new double[N];
            int t = 0;
            for (int worker = 0; worker < N; ++worker) {
                double price = factor * quality[worker];
                if (price < wage[worker]) continue;
                prices[t++] = price;
            }

            if (t < K) continue;
            Arrays.sort(prices, 0, t);
            double cand = 0;
            for (int i = 0; i < K; ++i)
                cand += prices[i];
            ans = Math.min(ans, cand);
        }

        return ans;
    }

    public double mincostToHireWorkers1(int[] quality, int[] wage, int K) {
        TreeMap<Double, List<Integer>> groups = buildSortedValueGroups(quality, wage);

        double[] value = groups.keySet().stream().mapToDouble(e -> e).sorted().toArray();

        int[][] g = new int[value.length][];

        int wc = 0;

        for (List<Integer> w : groups.values()) {
            g[wc++] = w.stream().mapToInt(e -> e).toArray();
        }

        double theMin = Double.MAX_VALUE;

        for (int i = 0; i < groups.size(); i++) {
            PriorityQueue<Worker> pq = buildPriorityQueue(g, wage, quality, value, i);

            if (pq.size() < K) continue;

            double thisMin = calculateMinCost(pq, value[i], K, theMin, i);

            if (thisMin == -1) continue;

            if (thisMin < theMin) { theMin = thisMin; }
        }

        return theMin == Double.MAX_VALUE ? -1 : theMin;
    }

    private double calculateMinCost(PriorityQueue<Worker> pq, double v, int k, double theMin, int base) {
        double total = 0;

        String path = "";

        for (int i = 0; i < k; i++) {
            Worker w = pq.poll();
            total += w.fv;
            path += "(" + w + ") ";

            if (total >= theMin) {
                return -1;
            }
        }

        return total;
    }

    private PriorityQueue<Worker> buildPriorityQueue(int[][] g, int[] wage, int[] quality, double[] value, int base) {
        double v = value[base];

        PriorityQueue<Worker> workers = new PriorityQueue<>(Comparator.comparingDouble(a -> a.fv));

        for (int i = base; i >= 0; i--) {
            for (int worker : g[i]) {
                Worker e = new Worker(wage[worker], quality[worker], v);
                workers.add(e);
            }
        }

        return workers;
    }

    private class Worker {
        int wage;
        int quality;
        double fv;
        double v;

        public Worker(int wage, int quality, double v) {
            this.wage = wage;
            this.quality = quality;
            this.fv = Math.max((double) wage, quality * v);
            this.v = v;
        }

        @Override
        public String toString() {
            return String.format("{%d/%d, v: %.2f, fw:%.2f}", wage, quality, v, fv);
        }
    }

    private TreeMap<Double, List<Integer>> buildSortedValueGroups(int[] quality, int[] wage) {
        TreeMap<Double, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < wage.length; i++) {
            double value = (double) wage[i] / (double) quality[i];
            map.putIfAbsent(value, new ArrayList<>());
            map.get(value).add(i);
        }

        return map;
    }
}
