from unittest import TestCase
from wcontest.wc147.Solution_1132 import Solution


class TestSolution(TestCase):
    def test_maxAbsValExpr(self):
        s = Solution()
        v = s.method()
        self.assertEqual(1, v)
