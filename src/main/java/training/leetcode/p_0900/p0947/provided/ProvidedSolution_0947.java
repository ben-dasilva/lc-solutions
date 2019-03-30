package training.leetcode.p_0900.p0947.provided;

import training.leetcode.p_0900.p0947.Solution_0947;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProvidedSolution_0947 extends Solution_0947 {
    public int removeStones(int[][] stones) {
        int N = stones.length;
        DSU dsu = new DSU(20);

        for (int[] stone: stones) {
            System.out.printf("\nAdding (%2d, %2d)... ", stone[0], stone[1]);
            dsu.union(stone[0], stone[1] + 10);
        }

        Set<Integer> seen = new HashSet<>();

        System.out.println("\n\n------------------------------------");
        System.out.println("Calculating number of graphs...\n");
        for (int[] stone: stones)
            seen.add(dsu.find(stone[0]));

        return N - seen.size();
    }
}

class DSU {
    public static final String SPACES = "                     ";
    int[] parent;

    public void dump() {
        System.out.print("p[x]: ");
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                System.out.print("|  ");
            } else {
                System.out.printf("|%02d", parent[i]);
            }
        }
        System.out.println("|");

        System.out.print("  x   ");
        for (int i = 0; i < parent.length; i++) {
            System.out.printf("|%02d", i);
        }
        System.out.println("|");
    }

    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;

        dump();
    }

    public int find(int x) {
        return find(x, 0);
    }
    public int find(int x, int level) {
        if (level > 0) System.out.println();

        System.out.printf("%sfind(%2s)", SPACES.substring(0, level*4), x);
        if (parent[x] != x) {

            int fx = find(parent[x], level+1);

            parent[x] = fx;
        } else
            System.out.printf("  -->  [%2s]\n", parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        System.out.printf("union(%2s, %2d)\n", x, y);
        int fy = find(y);
        int fx = find(x);

        parent[fx] = fy;

        dump();
    }
}
