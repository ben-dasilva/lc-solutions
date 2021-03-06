package training.leetcode.p_0400.p0482;

/*
 * You are given a license key represented as a string S which consists only
 * alphanumeric character and dashes. The string is separated into N+1 groups
 * by N dashes.
 *
 * Given a number K, we would want to reformat the strings such that each group
 * contains exactly K characters, except for the first group which could be
 * shorter than K, but still must contain at least one character. Furthermore,
 * there must be a dash inserted between two groups and all lowercase letters
 * should be converted to uppercase.
 *
 * Given a non-empty string S and a number K, format the string according to the
 * rules described above.
 */
public class Solution_0482 {
    public String licenseKeyFormatting(String S, int K) {
        String s = S.replaceAll("-", "").toUpperCase();

        int len = s.length();

        if (len == 0) return "";

        int chunk = len % K;
        if (chunk == 0) chunk = K;

        StringBuilder sb = new StringBuilder(s.substring(0, chunk));

        len -= chunk;

        int start = chunk;

        while (len > 0) {
            sb.append('-');
            sb.append(s, start, start+K);
            len -= K;
            start += K;
        }

        return sb.toString();
    }
}
