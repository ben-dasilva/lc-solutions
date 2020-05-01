from typing import List
from lcpy.tmp.tree_node import TreeNode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidSequence(self, root: TreeNode, arr: List[int]) -> bool:
        size = len(arr)

        def verify_sequence(node: TreeNode, i: int) -> bool:
            if i == size or node is None:
                return i == size and node is None

            if node.val != arr[i]:
                return False

            if node.left is None and node.right is None and i == size - 1:
                return True

            if node.left and verify_sequence(node.left, i + 1):
                return True

            if node.right and verify_sequence(node.right, i + 1):
                return True

            return False

        return verify_sequence(root, 0)


null = None

test_cases = (
    (True, [[0, 1, 0, 0, 1, 0, null, null, 1, 0, 0], [0, 1, 0, 1]]),
    (False, [[0, 1, 0, 0, 1, 0, null, null, 1, 0, 0], [0, 0, 1]]),
    (False, [[8, 3, null, 2, 1, 5, 4], [8]]),
)

for pair in test_cases:
    expected, (tree, path) = pair

    tree_node = TreeNode.load(tree)

    # print(tree_node)

    result = Solution().isValidSequence(tree_node, path)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {path}')
