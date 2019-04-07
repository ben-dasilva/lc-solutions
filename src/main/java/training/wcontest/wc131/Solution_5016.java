package training.wcontest.wc131;

import java.util.ArrayList;
import java.util.List;

public class Solution_5016 {
    public String removeOuterParentheses(String S) {
        int level = 0;
        List<Integer> outer = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (level == 0) {
                    outer.add(i);
                }
                level++;
                continue;
            }

            if (S.charAt(i) == ')') {
                level--;
                if (level == 0) {
                    outer.add(i);
                }
            }
        }
        int last = 0;

        StringBuilder sb = new StringBuilder();

        for (int remove : outer) {
            sb.append(S.substring(last, remove));
            last = remove+1;
        }
        return sb.toString();
    }
}
