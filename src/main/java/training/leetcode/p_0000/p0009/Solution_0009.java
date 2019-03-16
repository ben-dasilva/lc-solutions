package training.leetcode.p_0000.p0009;

public class Solution_0009 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        long tmp = x;
        long reversed = 0;

        while (x > 0) {
            reversed *= 10;
            reversed += x % 10;
            x /= 10;
        }

        return reversed == tmp;
    }
}
