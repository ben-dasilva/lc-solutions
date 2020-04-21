from typing import List
from lcpy.tmp.tree_node import TreeNode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        """Return the root node of a binary search tree that matches the given preorder traversal."""
        def find_in_hierarchy(node, new_v):
            while node:
                if new_v > node.val and not node.right:
                    return node

                node = node.right if new_v > node.val else node.left

        def build_bst(p_tree):
            root = node = TreeNode(p_tree[0])

            for i in range(1, len(preorder)):
                if p_tree[i] < p_tree[i-1]:
                    # easy case: must be left node
                    node.left = TreeNode(p_tree[i])
                    node = node.left
                else:
                    node = find_in_hierarchy(root, p_tree[i])
                    node.right = TreeNode(p_tree[i])
                    node = node.right

            return root

        return build_bst(preorder)


null = None
test_cases = (
    ([19, 4, null, null, 8, null, 11], [19, 4, 8, 11]),
    ([8, 5, 10, 1, 7, null, 12], [8, 5, 1, 7, 10, 12]),
    ([20, 10, 30, null, null, 25, 35, null, 27, null, null, 26], [20, 10, 30, 25, 27, 26, 35]),
)

for pair in test_cases:
    expected, args = pair

    preorder = Solution().bstFromPreorder(args)
    result = TreeNode.unload(preorder)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {args}')

    print(preorder.graphviz())


import bisect

# incredibly brilliant solution found online (I wish I had come up with that! Kudos to whoever wrote it):
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        if preorder:
            node = TreeNode(preorder[0])
            i = bisect.bisect(preorder, node.val)
            node.left = self.bstFromPreorder(preorder[1:i])
            node.right = self.bstFromPreorder(preorder[i:])
            return node
