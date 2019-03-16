package training.leetcode.p_0900.p0929;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution_0929Test {
    @Test
    public void ensure_lc_example_1_returns_2() {
        Solution_0929 s = new Solution_0929();

        int i = s.numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        });

        assertEquals(2, i);
    }

    @Test
    public void ensure_10_emails_are_counted_correctly() {
        Solution_0929 s = new Solution_0929();

        int i = s.numUniqueEmails(new String[]{
                "test.email.1@leetcode.com",
                "test.email.2@leetcode.com",
                "test.email.3@leetcode.com"
        });

        assertEquals(3, i);
    }

    @Test
    public void ensure_plus_emails_are_counted_correctly() {
        Solution_0929 s = new Solution_0929();

        int i = s.numUniqueEmails(new String[]{
                "test.email.1+a@leetcode.com",
                "test.email.1+b@leetcode.com",
                "test.email.1+@leetcode.com",
                "test.email.1++@leetcode.com",
                "test.email.1+++@leetcode.com",
                "test.email.1+a+1+@leetcode.com",
                "test.email.1+a+1+@leetcode.com",
        });

        assertEquals(1, i);
    }

    @Test
    public void ensure_empty_emails_are_counted_correctly() {
        Solution_0929 s = new Solution_0929();

        int i = s.numUniqueEmails(new String[]{
        });

        assertEquals(0, i);
    }
}