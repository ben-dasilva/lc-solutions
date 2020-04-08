from typing import List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x: int):
        self.val = x
        self.next = None

    @classmethod
    def of_list(cls, x: List[int]) -> 'ListNode':
        """Initialize ListNode from list"""
        x = reversed(x)
        prev = None
        head = None

        for e in x:
            head = cls(e)
            head.next = prev
            prev = head

        return head

    def add(self, v):
        new_node = ListNode(v)
        new_node.next = self.next
        self.next = new_node

    def __str__(self):
        return f'[{", ".join(str(_) for _ in self.as_list())}]'

    def as_list(self):
        s = []
        node = self
        while node is not None:
            s.append(node.val)
            node = node.next

        return s


class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        middle = head
        forward = head

        while forward and forward.next:
            middle = middle.next
            forward = forward.next.next

        return middle


test_cases = (
    ([1], [1]),
    ([2], [1, 2]),
    ([2, 3], [1, 2, 3]),
    ([3, 4], [1, 2, 3, 4]),
    ([3, 4, 5], [1, 2, 3, 4, 5]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().middleNode(ListNode.of_list(args)).as_list()

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {args}')