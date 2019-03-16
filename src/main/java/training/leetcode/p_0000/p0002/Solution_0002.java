package training.leetcode.p_0000.p0002;

/*
 * LC-0002: Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except
 * the number 0 itself.
 */
public class Solution_0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = null;
        ListNode prev = null;

        int carry = 0;

        while (p1 != null || p2 != null) {
            int d1 = p1 != null ? p1.val : 0;
            int d2 = p2 != null ? p2.val : 0;
            int sum = d1 + d2 + carry; // don't forget the carry

            ListNode newNode = new ListNode(sum % 10);

            if (result == null) {
                result = newNode;
                prev = newNode;
            } else {
                prev.next = newNode;
                prev = newNode;
            }

            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
            carry = sum > 9 ? 1 : 0;
        }

        // ATTENTION: don't forget to use the carry!

        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public static ListNode of(int val) {
            ListNode head;
            ListNode right = null;

            do {
                head = new ListNode(val % 10);
                val = val / 10;
                head.next = right;
                right = head;
            } while (val > 0);

            return head;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
