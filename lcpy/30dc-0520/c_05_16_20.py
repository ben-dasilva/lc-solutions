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


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if not head:
            return head

        odd, even = head, head.next
        first_even = even

        while odd.next and even.next:
            en, enn = even.next, even.next.next

            odd.next = en
            odd = en

            even.next = enn
            even = enn

        odd.next = first_even

        return head


test_cases = (
    ([], []),
    ([1], [1]),
    ([1, 2], [1, 2]),
    ([1, 3, 2, 4], [1, 2, 3, 4]),
    ([1, 3, 5, 2, 4], [1, 2, 3, 4, 5]),
    ([2, 3, 6, 7, 1, 5, 4], [2, 1, 3, 5, 6, 4, 7]),
)


def as_list(r):
    return r.as_list() if r else []


# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().oddEvenList(ListNode.of_list(args))

    message = "OK" if as_list(result) == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {args}')
