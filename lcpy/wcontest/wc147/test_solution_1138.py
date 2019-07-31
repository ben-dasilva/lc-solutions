from unittest import TestCase
from wcontest.wc147.Solution_1138 import Solution


class TestSolution(TestCase):
    def test_maxAbsValExpr(self):
        s = Solution()
        v = s.alphabetBoardPath("leet")
        self.assertEqual("DDR!UURRR!!DDD!", v)

    def test_maxAbsValExpr2(self):
        s = Solution()
        v = s.alphabetBoardPath("code")
        self.assertEqual("RR!DDRR!UUL!R!", v)

    def test_maxAbsValExpr3(self):
        s = Solution()
        v = s.alphabetBoardPath("zip")
        self.assertEqual("DDDDD!UUUURRR!DDLLL!", v)

    def test_maxAbsValExpr4(self):
        s = Solution()
        v = s.alphabetBoardPath("pizza")
        self.assertEqual("DDD!UURRR!LLLDDDD!!UUUUU!", v)
