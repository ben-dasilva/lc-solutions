package training.leetcode.p_0900.p0929;

import java.util.Arrays;

public class Solution_0929 {
    public int numUniqueEmails(String[] emails) {
        return (int) Arrays.stream(emails)
                .map(e -> {
                    String[] s = e.split("@");
                    return s[0].replaceAll("\\.|\\+.*", "") + "@" + s[1];
                })
                .distinct()
                .count();
    }
}
