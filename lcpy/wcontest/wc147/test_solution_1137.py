from unittest import TestCase
from wcontest.wc147.Solution_1137 import Solution


class TestSolution(TestCase):
    def test_maxAbsValExpr(self):
        s = Solution()
        v = s.tribonacci(4)
        self.assertEqual(4, v)

    def test_maxAbsValExpr_2(self):
        s = Solution()
        v = s.tribonacci(5)
        self.assertEqual(7, v)

    def test_maxAbsValExpr_1(self):
        s = Solution()
        v = s.tribonacci(1)
        self.assertEqual(1, v)

    def test_maxAbsValExpr_0(self):
        s = Solution()
        v = s.tribonacci(0)
        self.assertEqual(0, v)

    def test_maxAbsValExpr_3(self):
        s = Solution()
        v = s.tribonacci(3)
        self.assertEqual(2, v)
