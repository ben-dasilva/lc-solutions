package training.other;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] sArray = s.toCharArray();
        int max = 0;
        int start = 0;

        Map<Character, Short> counts = new HashMap<>();

        int inputLength = s.length();
        System.out.println("inputLength = " + inputLength);
        for (short i = 0; i < inputLength; i++) {
            char key = sArray[i];
            Short previous = counts.put(key, i);

            System.out.format("[%3d] '%c' [%2d][%2s][max: %2d]\n", i, key, start, previous == null ? "--" : previous.toString(), max);
            if (previous != null && previous >= start) {
                int p = previous.intValue();
                // record word, if longest; then truncate leading characters up to ${key}
                if (i - start > max) {
                    max = i - start;
                }

                start = previous;
            }
        }
        System.out.format("[%3d][%2d][%2s][max: %2d]\n", inputLength, start, "--", max);

        return Math.max(max, inputLength - start);
    }

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();

        int length = ls.lengthOfLongestSubstring("abba");

        System.out.println("length = " + length);
    }
}
