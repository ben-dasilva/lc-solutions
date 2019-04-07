package training.wcontest.wc131;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Solution_5018 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            result.add(lcMatch(query, pattern));
        }

        return result;
    }

    private boolean lcMatch(String query, String pattern) {
        int qp = 0;
        int pp = 0;

        while (qp < query.length()) {
            char qc = query.charAt(qp);
            char pc = pp < pattern.length() ? pattern.charAt(pp) : ' ';

            // System.out.printf("Comparing '%c' and '%c'...\n", qc, pc);
            if (qc != pc) {
                if (isLowerCase(qc)) {
                    qp++;
                    continue;
                } else {
                    return false;
                }
            } else {
                qp++;
                pp++;
            }
        }


        return pp == pattern.length();
    }

    private boolean isLowerCase(char qc) {
        return qc >= 'a' && qc <= 'z';
    }
}
