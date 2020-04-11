from typing import List
from collections import deque


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    @staticmethod
    def load(tree: List):
        root = TreeNode(tree[0])

        nodes = deque([root])

        for p in range(1, len(tree), 2):
            if not nodes:
                continue

            cur = nodes.popleft()

            if tree[p] is not None:
                cur.left = TreeNode(tree[p])
                nodes.append(cur.left)

            if p + 1 < len(tree) and tree[p + 1] is not None:
                cur.right = TreeNode(tree[p + 1])
                nodes.append(cur.right)

        return root

    def __repr__(self):
        result = []

        def print_node(node: TreeNode, level=0):
            if node is None or node.val is None:
                result.append(f'{"  " * level}None')
                return

            result.append(f'{"  " * level}{node.val}')
            print_node(node.left, level + 1)
            print_node(node.right, level + 1)

        print_node(self)
        return "\n".join(result)

    def graphviz(self):
        result = []

        def print_node(node: TreeNode, parent=None) -> None:
            import random
            # if node is None: return
            if node is None:
                rand = random.randrange(1e9)
                result.append(f'{parent.val}->{rand} [color=none];')
                result.append(f'{rand} [label="",color=none];')
                return

            if parent is not None:
                result.append(f'{parent.val}->{node.val};')

            print_node(node.left, node)
            print_node(node.right, node)

        result.append("digraph G {\n    ")

        print_node(self)
        result.append("\n}")
        return "\n    ".join(result)


class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        """Given a binary tree, you need to compute the length of the diameter
         of the tree. The diameter of a binary tree is the length of the
         longest path between any two nodes in a tree. This path may or may
         not pass through the root."""

        if not root:
            return 0

        def depth_and_diameter(root: TreeNode) -> (int, int):
            if not root:
                return 0, 0

            l_depth, l_diameter = depth_and_diameter(root.left)
            r_depth, r_diameter = depth_and_diameter(root.right)

            return 1 + max(l_depth, r_depth), max(1 + l_depth + r_depth, l_diameter, r_diameter)

        depth, diameter = depth_and_diameter(root)

        return diameter - 1


null = None

test_cases = (
    (0, [1]),
    (1, [1, 2]),
    (3, [1, 2, 3, 4, 5]),
    (2, [1, 2, 3]),
    (5, [1, 2, 3, 4, 5, null, 7, 8, null, null, 11]),
    (5, [1, 2, 3, 4, 5, null, 7, 8, null, null, 11]),
    (6, [1, 2, 3, 4, 5, null, 7, 8, null, null, 11, null, null, 12, null, null, 13]),
    (8, [1, 2, 3, 4, 5, null, 7, 8, null, null, 11, null, null, 12, null, null, 13, 14, null, null, 15]),
)

for pair in test_cases:
    expected, args = pair

    tree_node = TreeNode.load(args)

    # print(tree_node)

    result = Solution().diameterOfBinaryTree(tree_node)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
