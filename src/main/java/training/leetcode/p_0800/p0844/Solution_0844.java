package training.leetcode.p_0800.p0844;

/**
 * <h3> LC-0844: Backspace String Compare </h3>
 *
 * <p>
 *     Given two strings <b>S</b> and <b>T</b>, return if they are equal when both are typed into
 *     empty text editors. <b>#</b> means a backspace character.
 * </p>
 *
 * <h4> Example 1: </h4>
 * <pre>
 *   Input: S = "ab#c", T = "ad#c"
 *   Output: true
 *   Explanation: Both S and T become "ac".
 * </pre>
 */
public class Solution_0844 {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        int sp = s.length-1;
        int tp = t.length-1;

        while (sp >= -1 || tp >= -1) {
            sp = walkBackDeletions(s, sp);
            tp = walkBackDeletions(t, tp);

            if (sp == -1 && tp != -1 || sp != -1 && tp == -1) return false;

            if (sp == -1) return true;

            if (s[sp] != t[tp]) return false;

            sp--;
            tp--;
        }

        return true;
    }

    private int walkBackDeletions(char[] text, int p) {
        int deletions;
        int i;

        do {
            deletions = 0;

            while (p-deletions >= 0 && text[p-deletions] == '#') {
                deletions++;
            }

            p = Math.max(-1, p - deletions);

            i = 0;

            for (; p - i >= 0 && i < deletions; i++) {
                if (text[p-i] == '#') deletions += 2;
            }

            p -= i;
        } while (deletions > 0);

        return p-i;
    }
}
