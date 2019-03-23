package training.leetcode.p_0300.p0399;

import java.util.*;

/**
 * <h3> LC-0399. Evaluate Division </h3>
 *
 * <p>
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real
 * number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * </p>
 *
 * <h4> Example: </h4>
 *
 * <pre>
 *   Given a / b = 2.0, b / c = 3.0.
 *   queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 *   return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * </pre>
 *
 * <p>
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 * where equations.size() == values.size(), and the values are positive. This represents the equations. Return
 * vector<double>.
 * </p>
 *
 * <p>
 * According to the example above:
 * </p>
 *
 * <pre>
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * </pre>
 * <p>
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is
 * no contradiction.
 */
public class Solution_0399 {
    static int ops = 0;

    double findPath(Map<String, Map<String, Double>> relations, String from, String to) {
        Stack<String> path = new Stack<>();

        // DFS -- search for 'to', starting at 'from'
        dfs(path, new HashSet<>(), relations, from, to);

        if (path.empty()) return -1;

        if (path.size() == 1) return 1;

        double result = 1;

        String prev = path.get(0);

        for (int i = 1; i < path.size(); i++) {
            String current = path.get(i);

            result *= relations.get(prev).get(current);

            prev = current;
        }

        System.out.println("ops = " + ops);
        return result;
    }

    private boolean dfs(Stack<String> path, Set<String> visited, Map<String, Map<String, Double>> relations, String from, String to) {
        ops++;

        if (visited.contains(from)) return false;

        Map<String, Double> knownNeighbours = relations.get(from);

        if (knownNeighbours == null) return false;

        path.push(from);

        visited.add(from);

        if (to.equals(from)) return true;

        if (knownNeighbours.containsKey(to) && !visited.contains(to)) {
            path.add(to);
            return true;
        }

        for (String neighbour : knownNeighbours.keySet()) {
            if (dfs(path, visited, relations, neighbour, to)) return true;
        }

        path.pop();

        return false;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        ops = 0;
        long start = System.currentTimeMillis();
        Map<String, Map<String, Double>> knownRelations = buildRelations(equations, values);

        double[] doubles = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String[] q = queries[i];
            doubles[i] = findPath(knownRelations, q[0], q[1]);
        }

        long end   = System.currentTimeMillis();

        System.out.println("ELAPSED: " + (end - start));

        return doubles;
    }

    private Map<String, Map<String, Double>> buildRelations(String[][] equations, double[] values) {
        HashMap<String, Map<String, Double>> relations = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            addToSet(relations, equations[i], values[i]);
            ops += 2;
        }

        return relations;
    }

    private void addToSet(HashMap<String, Map<String, Double>> knownRelations, String[] equation, double value) {
        String a = equation[0];
        String b = equation[1];

        knownRelations.putIfAbsent(a, new HashMap<>());
        knownRelations.putIfAbsent(b, new HashMap<>());

        knownRelations.get(a).put(b, value);
        knownRelations.get(b).put(a, 1/value);
    }
}
