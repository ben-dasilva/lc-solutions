package training.leetcode.p_0000.p0006;

class Solution_0006 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < chars.length; ) {
                sb.append(chars[i]);

                // bonus character (if available)
                if (row != 0 && row != numRows-1) {
                    int bonus = i + 2*(numRows - row - 1);

                    if (bonus < chars.length) sb.append(chars[bonus]);
                }

                // calculate next position
                i += row + 2*numRows - 2 - row;
            }
        }

        return sb.toString();
    }
}