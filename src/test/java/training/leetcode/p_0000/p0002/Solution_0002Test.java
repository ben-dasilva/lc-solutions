package training.leetcode.p_0000.p0002;

import org.junit.Test;

public class Solution_0002Test {
    @Test
    public void ensure342plus465equals807() {
        Solution_0002.ListNode a = Solution_0002.ListNode.of(342);
        Solution_0002.ListNode b = Solution_0002.ListNode.of(465);

        Solution_0002.ListNode result = new Solution_0002().addTwoNumbers(a, b);

        System.out.println("result = " + result);
    }
}