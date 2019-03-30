package training.leetcode.p_0900.p0947;

import java.util.*;

/**
 * <h2> LC-0947. Most Stones Removed with Same Row or Column </h2>
 *
 * <h3> Solution </h3>
 * It turns out this is a <b>graph</b> problem. The number of stones that can be removed is
 *
 * <code>#{removed} = #{stones} - #{graphs} </code>
 */
public class Solution_0947 {
    private static class Stone {
        int row;
        int col;

        public Stone(int[] rowcol) {
            this.row = rowcol[0];
            this.col = rowcol[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Stone stone = (Stone) o;
            return row == stone.row &&
                    col == stone.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public int removeStones(int[][] stones) {
        // strategy: build connection counter
        Map<Integer, Set<Stone>> rows = new HashMap<>();
        Map<Integer, Set<Stone>> cols = new HashMap<>();

        List<Stone> stoneList = buildRowCol(stones, rows, cols);

        int count = stoneList.size();

        int numGraphs = countGraphs(stoneList, rows, cols);

        return count - numGraphs;
    }

    private int countGraphs(List<Stone> stoneList, Map<Integer, Set<Stone>> rows, Map<Integer, Set<Stone>> cols) {
        Set<Stone> visited = new HashSet<>();
        Queue<Stone> toBeVisited = new ArrayDeque<>();

        int graphs = 0;

        for (Stone stone : stoneList) {
            toBeVisited.add(stone);
            if (visited.contains(stone)) continue;
            graphs++;

            while (!toBeVisited.isEmpty()) {
                Stone next = toBeVisited.remove();
                if (visited.contains(next)) continue;

                visited.add(next);

                toBeVisited.addAll(getNeighbors(next, rows, cols));
            }
        }

        return graphs;
    }

    private Set<Stone> getNeighbors(Stone stone, Map<Integer, Set<Stone>> rows, Map<Integer, Set<Stone>> cols) {
        Set<Stone> neighbours = new HashSet<>(rows.get(stone.row));

        neighbours.addAll(cols.get(stone.col));
        neighbours.remove(stone);

        return neighbours;
    }

    private List<Stone> buildRowCol(int[][] stones, Map<Integer, Set<Stone>> rows, Map<Integer, Set<Stone>> cols) {
        List<Stone> stoneList = new ArrayList<>();

        for (int[] stone : stones) {
            Integer row = stone[0];
            Integer col = stone[1];

            Stone s = new Stone(stone);
            stoneList.add(s);

            rows.putIfAbsent(row, new HashSet<>());
            rows.get(row).add(s);

            cols.putIfAbsent(col, new HashSet<>());
            cols.get(col).add(s);
        }

        return stoneList;
    }
}
