from lcpy.tmp.tree_node import TreeNode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:

        #print(root.graphviz())
        h = None

        def max_sum(node):
            nonlocal h
            nums_node = [0]

            l_sum = r_sum = 0
            val = node.val

            if node.left is not None:
                l_sum = max_sum(node.left)
                nums_node.append(l_sum)
                nums_node.append(l_sum - val)

            if node.right is not None:
                r_sum = max_sum(node.right)
                nums_node.append(r_sum)
                nums_node.append(r_sum - val)

            if node.left is not None and node.right is not None:
                nums_node.append(l_sum + r_sum)

            nums_ = [x + val for x in nums_node]
            #print(f'node: {node.node_str()}, sums: {nums_} --> max: {max(nums_)}')
            node_sum = max(nums_)
            h = node_sum if h is None else max(node_sum, h)
            #print(f'subtotal --> (node: {node_sum}, graph: {h}, return: max({val, val + l_sum, val + r_sum}))')
            return max(val, val + l_sum, val + r_sum)

        max_sum(root)
        # print(f'TOTAL: {h}')

        return h


null = None

test_cases = (
    (4, [1, -2, 3]),
    (-3, [-3]),
    (6, [1, 2, 3]),
    (42, [-10, 9, 20, null, null, 15, 7]),
    (3, [1, -2, -3, 1, 3, -2, null, -1]),
    (48, [5,4,8,11,null,13,4,7,2,null,null,null,1]),
)

for pair in test_cases:
    expected, args = pair

    tree_node = TreeNode.load(args)

    # print(tree_node)

    result = Solution().maxPathSum(tree_node)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
