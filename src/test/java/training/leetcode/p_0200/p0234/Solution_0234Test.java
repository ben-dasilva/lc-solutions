package training.leetcode.p_0200.p0234;

import org.junit.Test;
import static org.junit.Assert.*;

public class Solution_0234Test {
    @Test
    public void ensure_1_2_3_is_not_palindrome() {
        Solution_0234 solution = new Solution_0234();

        ListNode list = buildList(1, 2, 3);

        assertFalse(solution.isPalindrome(list));
    }

    @Test
    public void ensure_1_2_3_2_1_is_palindrome() {
        Solution_0234 solution = new Solution_0234();

        ListNode list = buildList(1, 2, 3, 2, 1);

        assertTrue(solution.isPalindrome(list));
    }

    @Test
    public void ensure_1_2_2_1_is_palindrome() {
        Solution_0234 solution = new Solution_0234();

        ListNode list = buildList(1, 2, 2, 1);

        assertTrue(solution.isPalindrome(list));
    }

    @Test
    public void ensure_1_is_palindrome() {
        Solution_0234 solution = new Solution_0234();

        ListNode list = buildList(1);

        assertTrue(solution.isPalindrome(list));
    }

    @Test
    public void ensure_1_1_is_palindrome() {
        Solution_0234 solution = new Solution_0234();

        ListNode list = buildList(1, 1);

        assertTrue(solution.isPalindrome(list));
    }

    @Test
    public void ensure_empty_list_is_palindrome() {
        Solution_0234 solution = new Solution_0234();

        ListNode list = null;

        assertTrue(solution.isPalindrome(list));
    }

    private ListNode buildList(int... n) {
        ListNode head = new ListNode(n[0]);
        ListNode current = head;

        for (int i = 1; i < n.length; i++) {
            current.next = new ListNode(n[i]);
            current = current.next;
        }

        return head;
    }
}