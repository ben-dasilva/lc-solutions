package training.leetcode.p_0900.p0975;

import java.util.*;

/**
 * <h2> LC-0975: Odd Even Jump </h2>
 *
 * <p>
 * You are given an integer array A.  From some starting index, you can make a series of jumps. The (1st, 3rd, 5th, ...)
 * jumps in the series are called odd numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the series are called even
 * numbered jumps.
 * </p>
 *
 * <p>
 * You may from index i jump forward to index j (with i < j) in the following way:
 * </p>
 *
 * <ul>
 * <li>
 * During odd numbered jumps (ie. jumps 1, 3, 5, ...), you jump to the index j such that A[i] <= A[j] and A[j] is the
 * smallest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.
 * </li>
 * <li>
 * During even numbered jumps (ie. jumps 2, 4, 6, ...), you jump to the index j such that A[i] >= A[j] and A[j] is the
 * largest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.
 * </li>
 * <li>
 * (It may be the case that for some index i, there are no legal jumps.)
 * </li>
 * </ul>
 *
 * <p>
 * A starting index is good if, starting from that index, you can reach the end of the array (index A.length - 1) by
 * jumping some number of times (possibly 0 or more than once.)
 * </p>
 *
 * <p>
 * Return the number of good starting indexes.
 * </p>
 */
public class Solution_0975 {
    public int oddEvenJumps(int[] A) {
        Boolean[][] knownJumps = {
                new Boolean[A.length],
                new Boolean[A.length],
        };

        int[] nextUp   = new int[A.length];
        int[] nextDown = new int[A.length];
        int[] nextSame = new int[A.length];

        TreeMap<Integer, Integer> valToIndex = new TreeMap<>();

        int lastIndex = A.length - 1;

        int total = 0;

        // starting from the last element, then going to the first element
        for (int i = lastIndex; i >= 0; i--) {
            int thisValue = A[i];

            Integer sameIndex                         = valToIndex.get(thisValue);
            Map.Entry<Integer, Integer> nextEntryUp   = valToIndex.higherEntry(thisValue);
            Map.Entry<Integer, Integer> nextEntryDown = valToIndex.lowerEntry(thisValue);

            nextSame[i] = i == lastIndex ? -1 : sameIndex     == null ? -1 : sameIndex;
            nextUp[i]   = i == lastIndex ? -1 : nextEntryUp   == null ? -1 : nextEntryUp.getValue();
            nextDown[i] = i == lastIndex ? -1 : nextEntryDown == null ? -1 : nextEntryDown.getValue();

            valToIndex.merge(thisValue, i, (old, v) -> v);

            int jumpable = canJumpToEnd(A, i, 1, knownJumps, nextSame, nextUp, nextDown, valToIndex);
            total += jumpable;
        }

        return total;
    }

    private int canJumpToEnd(int[] a, int start, int jump, Boolean[][] knownJumps, int[] nextSame, int[] nextUp, int[] nextDown, TreeMap<Integer, Integer> valToIndex) {
        Boolean[] jumps = knownJumps[jump % 2];
        Boolean jumpedBefore = jumps[start];

        if (jumpedBefore != null) return jumpedBefore ? 1 : 0;

        if (a.length == start+1) {
            jumps[start] = true;
            return 1;
        }

        int next = findNextIndex(start + 1, jump, nextSame, nextUp, nextDown);

        if (next == -1) {
            jumps[start] = false;
            return 0;
        }

        int canJump = canJumpToEnd(a, next, jump + 1, knownJumps, nextSame, nextUp, nextDown, valToIndex);

        jumps[start] = canJump == 1;

        return canJump;
    }

    private int findNextIndex(int start, int jump, int[] nextSame, int[] nextUp, int[] nextDown) {
        if (nextSame[start - 1] != -1) return nextSame[start - 1];

        return jump % 2 == 0 ? nextDown[start - 1] : nextUp[start - 1];
    }
}
