package training.leetcode.p_0000.p0008;

public class Solution_0008 {
    enum State {BEFORE, NUMBER}

    private static final int MAX_10 =     Integer.MAX_VALUE / 10;
    private static final int MIN_10 = -  (Integer.MIN_VALUE / 10);

    private static final int MAX_LAST =   Integer.MAX_VALUE % 10;
    private static final int MIN_LAST = -(Integer.MIN_VALUE % 10);

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();

        State state = State.BEFORE;

        int result = 0;
        int sign = 1;

        for (char c : chars) {
            switch (state) {
                case BEFORE:
                    if (c == ' ') {
                        continue;
                    } else if (c == '-') {
                        state = State.NUMBER;
                        sign = -1;
                        continue;
                    } else if (c == '+') {
                        state = State.NUMBER;
                        sign = 1;
                        continue;
                    }

                    if (c >= '0' && c <= '9') {
                        state = State.NUMBER;
                    } else {
                        return 0;
                    }

                case NUMBER:
                    if (c < '0' || c > '9') return result * sign;

                    int digit = (c - '0');

                    if (sign == 1) {
                        if (result > MAX_10) return Integer.MAX_VALUE;
                        if (result == MAX_10 && digit > MAX_LAST) return Integer.MAX_VALUE;
                    }

                    if (sign == -1) {
                        if (result > MIN_10) return Integer.MIN_VALUE;
                        if (result == MIN_10 && digit > MIN_LAST) return Integer.MIN_VALUE;
                    }

                    result = result * 10 + (c - '0');
            }
        }

        return result * sign;
    }
}
