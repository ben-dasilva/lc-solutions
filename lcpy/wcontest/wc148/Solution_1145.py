from typing import List
from collections import deque


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
    @staticmethod
    def dump(v):
        print(', '.join([f'{k}: {v}' for k, v in v.items() if k != 'self']))

    def btreeGameWinningMove(self, root: TreeNode, n: int, x: int) -> bool:
        def find_and_apply(root: TreeNode, target: int, f):
            if root is None: return 0

            if root.val == target: return f(root)

            v = find_and_apply(root.left, target, f)

            if v: return v

            return find_and_apply(root.right, target, f)

        def child_count(node: TreeNode):
            return 0 if node is None else 1 + child_count(node.left) + child_count(node.right)

        def left_right_counts(node: TreeNode):
            return child_count(node.left), child_count(node.right)

        left, right = find_and_apply(root, x, left_right_counts)

        other = n - left - right - 1
        small_1, small_2, large = sorted([left, right, other])

        return large > small_1 + small_2
