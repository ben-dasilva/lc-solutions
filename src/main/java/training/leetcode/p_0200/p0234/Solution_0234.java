package training.leetcode.p_0200.p0234;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class Solution_0234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        int[] length = {0};

        ListNode reversed = buildReversed(head, length);

        ListNode p1 = head;
        ListNode p2 = reversed;

        int max = length[0]/2;

        while (max-- > 0) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public ListNode buildReversed(ListNode node, int[] length) {
        if (node == null)
            return null;

        ListNode head = new ListNode(node.val);
        length[0]++;

        while (node.next != null) {
            node = node.next;
            ListNode current = new ListNode(node.val);
            length[0]++;
            current.next = head;
            head = current;
        }

        return head;
    }
}



