from unittest import TestCase
from wcontest.wc148.Solution_1145 import Solution, TreeNode

null = None


class TestSolution(TestCase):
    def test_5_1(self):
        s = Solution()
        a = [1, 2, 3, 4, 5]
        v = s.btreeGameWinningMove(TreeNode.load(a), 5, 1)
        self.assertEqual(True, v)

    def test_3_1(self):
        s = Solution()
        a = [1, 2, 3]
        v = s.btreeGameWinningMove(TreeNode.load(a), 3, 1)
        self.assertEqual(False, v)

    def test_9_1(self):
        s = Solution()
        a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        v = s.btreeGameWinningMove(TreeNode.load(a), 9, 1)
        self.assertEqual(True, v)

    def test_9_2(self):
        s = Solution()
        a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        v = s.btreeGameWinningMove(TreeNode.load(a), 9, 2)
        self.assertEqual(False, v)

    def test_7_5(self):
        s = Solution()
        a = [3, null, 6, null, 7, 4, null, 1, 2, null, null, 5]
        root = TreeNode.load(a)
        # print(root)
        # print(root.graphviz())
        v = s.btreeGameWinningMove(root, 7, 4)
        self.assertEqual(False, v)
