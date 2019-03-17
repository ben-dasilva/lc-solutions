package training.wcontest.wc127.leetcode1005;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Set<Integer> aSet = new HashSet<>();
        Map<Integer, List<Integer>> collect = getIntegerListMap(A, aSet);

        List<Integer> aList = getUniqueList(aSet);

        // first flip the negatives
        List<Integer> negatives = aList.stream()
                .filter(e -> e < 0)
                .flatMap(key -> collect.get(key).stream())
                .limit(K).collect(Collectors.toList());

        negatives.forEach(n -> A[n] = -A[n]);

        K -= negatives.size();

        // then flip the smallest positive
        K = K % 2;

        aSet = new HashSet<>();

        Map<Integer, List<Integer>> collect2 = getIntegerListMap(A, aSet);
        aList = getUniqueList(aSet);

        List<Integer> positives = aList.stream()
                .filter(e -> e >= 0).flatMap(key -> collect2.get(key).stream()).limit(K).collect(Collectors.toList());

        positives.forEach(n -> A[n] = -A[n]);

        return Arrays.stream(A).sum();
    }

    private List<Integer> getUniqueList(Set<Integer> aSet) {
        List<Integer> aList = new ArrayList<>(aSet);
        aList.sort(Comparator.comparingInt(e -> e));
        return aList;
    }

    private Map<Integer, List<Integer>> getIntegerListMap(int[] A, Set<Integer> aSet) {
        List<int[]> temp = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            temp.add(new int[] {i, A[i]});
            aSet.add(A[i]);
        }

        Map<Integer, List<Integer>> collect = temp.stream().collect(Collectors.groupingBy(elem -> elem[1],
                Collectors.mapping(ele -> ele[0], Collectors.toList())));

        return collect;
    }
}
