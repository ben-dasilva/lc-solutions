from unittest import TestCase
from wcontest.wc148.Solution_1141 import Solution


class TestSolution(TestCase):
    def test_maxAbsValExpr(self):
        s = Solution()
        v = s.stoneGameII([2, 7, 9, 4, 4])
        self.assertEqual(10, v)
