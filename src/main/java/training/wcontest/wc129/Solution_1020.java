package training.wcontest.wc129;

import java.util.*;

/**
 * <h3> LC-1020: Partition Array Into Three Parts With Equal Sum </h3>
 *
 * HORRIBLE SOLUTION :P
 *
 * The RIGHT way of doing this:
 *   1) Sum MUST be divisible by 3
 *   2) Find 1st section that adds up to size/3
 *   3) find 2nd section that adds up to 2*(size/3).
 *   4) You are DONE.
 *
 *   Keep this code to remind you what horrible, over-engineered code looks like.
 *
 *   How to do better next time:
 *   - Figure out the basic problem being solved BEFORE starting to code
 *   - Don't over-engineer :P
 */
public class Solution_1020 {
    public boolean canThreePartsEqualSum(int[] A) {
        // memoization
        int[] sumFromLeft  = new int[A.length];
        int[] sumFromRight = new int[A.length];
        int[] crossDiff    = new int[A.length];

        sumFromLeft[0] = A[0];
        sumFromRight[A.length-1] = A[A.length-1];

        for (int i = 1; i < A.length; i++) {
            sumFromLeft[i] = A[i] + sumFromLeft[i-1];
            sumFromRight[A.length - 1 - i] = A[A.length - 1 - i] + sumFromRight[A.length - i];
        }

        Map<Integer, List<Integer>> maybeLeft = new HashMap<>();
        Map<Integer, List<Integer>> maybeRight = new HashMap<>();

        for (int i = 1; i < A.length; i++) {
            int diff = sumFromRight[i] - sumFromLeft[i - 1];

            if (diff == sumFromLeft[i-1]) {
                maybeLeft.putIfAbsent(diff, new LinkedList<>());
                maybeLeft.get(diff).add(i);
            }

            diff = sumFromLeft[i - 1] - sumFromRight[i];

            if (diff == sumFromRight[i]) {
                maybeRight.putIfAbsent(diff, new LinkedList<>());
                maybeRight.get(diff).add(i);
            }
        }

        int total = sumFromRight[0];

        maybeLeft.put(2, new LinkedList<>());
        System.out.println("(before) maybeLeft = " + maybeLeft);
        System.out.println("(before) maybeRight = " + maybeRight);

        maybeLeft.keySet().retainAll(maybeRight.keySet());

        System.out.println("A = " + Arrays.toString(A));
        System.out.println("sumFromLeft = " + Arrays.toString(sumFromLeft));
        System.out.println("sumFromRight = " + Arrays.toString(sumFromRight));

        System.out.println("maybeLeft = " + maybeLeft);
        System.out.println("maybeRight = " + maybeRight);
        Set<Integer> candidates = maybeLeft.keySet();

        for (Integer candidate : candidates) {
            List<Integer> leftBoundaries = maybeLeft.get(candidate);
            List<Integer> rightBoundaries = maybeRight.get(candidate);
            for (int i = 0; i < leftBoundaries.size(); i++) {
                for (int j = 0; j < rightBoundaries.size(); j++) {
                    Integer left = leftBoundaries.get(i);
                    Integer right = rightBoundaries.get(j);
                    if (left > right) continue;

                    if (sumFromLeft[left-1] == sumFromRight[right]) {
                        System.out.printf("FOUND IT!! (%d, %d)\n", left, right);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
