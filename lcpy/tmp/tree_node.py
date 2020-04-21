from typing import List
from collections import deque


# noinspection DuplicatedCode
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

            if p+1 < len(tree) and tree[p + 1] is not None:
                cur.right = TreeNode(tree[p + 1])
                nodes.append(cur.right)

        return root

    @staticmethod
    def unload(tree: 'TreeNode'):
        q = deque([tree])
        ret = []
        last = 0
        while q:
            t = q.popleft()
            if t:
                ret.append(t.val)
                if t.val:
                    last = len(ret)

                q.append(t.left)
                q.append(t.right)
            else:
                ret.append(None)

        return ret[:last]

    def node_str(self):
        return f'({self.left.val if self.left else "__"}, {self.val}, {self.right.val if self.right else "__"})'

    def __repr__(self):
        result = []

        def print_node(node: TreeNode, level=0):
            if node is None:
                result.append(f'{"  " * level}None')
                return
            if node.val is None:
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
                result.append(f'{parent.val}->{rand} [color=lightgrey];')
                result.append(f'{rand} [label="",color=lightgrey];')
                return

            if parent is not None:
                result.append(f'{parent.val}->{node.val};')

            print_node(node.left, node)
            print_node(node.right, node)

        result.append("digraph G {\n    ")

        print_node(self)
        result.append("\n}")
        return "\n    ".join(result)


#null = None
#t = TreeNode.load([3, null, 6, null, 7, 4, null, 1, 2, null, null, 5])

#print(t.graphviz())
