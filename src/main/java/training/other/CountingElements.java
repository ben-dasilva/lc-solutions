package training.other;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingElements {
    public int countElements(int[] arr) {
        final Set<Integer> counted = Arrays.stream(arr).boxed()
                .map(i -> i - 1)
                .collect(Collectors.toSet());

        return (int) Arrays.stream(arr).boxed()
                .filter(counted::contains)
                .count();
    }
}

