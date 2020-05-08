from lcpy.tmp.tree_node import TreeNode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        max_l = -1

        def find_in_tree(node, v, l=0, p=None):
            if node is None:
                return None

            if node.val == v:
                return p, l

            l += 1

            if max_l < 0 or l < max_l:
                ret = find_in_tree(node.left, v, l, node.val) or \
                      find_in_tree(node.right, v, l, node.val)
                return ret

            return None

        x_parent, x_level = find_in_tree(root, x)
        y_parent, y_level = find_in_tree(root, y)

        return x_level == y_level and x_parent != y_parent


null = None
test_cases = (
    (False, [4, 3, [1, 2, 3, 4]]),
    (True, [5, 4, [1, 2, 3, null, 4, null, 5]]),
    (False, [2, 3, [1, 2, 3, null, 4]]),
)

for pair in test_cases:
    expected, (x, y, args) = pair

    tree = TreeNode.load(args)

    cousin = Solution().isCousins(tree, x, y)
    result = cousin

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {args}')
