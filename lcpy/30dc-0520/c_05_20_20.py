from lcpy.tmp.tree_node import TreeNode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        total = 0
        v = -1

        def traverse(node: TreeNode):
            nonlocal total, v
            if not node:
                return

            traverse(node.left)
            total += 1
            if total == k:
                v = node.val
                return
            traverse(node.right)

        traverse(root)
        return v


null = None

test_cases = (
    (1, 1, [1]),
    (2, 2, [2, 1]),
    (1, 1, [3, 1, 4, null, 2]),
    (3, 3, [5, 3, 6, 2, 4, null, null, 1]),
)

for pair in test_cases:
    expected, kth, args = pair

    tree_node = TreeNode.load(args)

    # print(tree_node)

    result = Solution().kthSmallest(tree_node, kth)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result}, input: {kth, args}')
