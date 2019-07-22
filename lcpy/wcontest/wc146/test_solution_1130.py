from unittest import TestCase

from wcontest.wc146.Solution_1130 import Solution


class TestSolution(TestCase):
    def test_mctFromLeafValues(self):
        s = Solution()
        self.assertEqual(32, s.mctFromLeafValues([6, 2, 4]))

    def test_mctFromLeafValues_2(self):
        s = Solution()
        self.assertEqual(276, s.mctFromLeafValues([11, 12, 12]))

    def test_mctFromLeafValues_3(self):
        s = Solution()
        self.assertEqual(500, s.mctFromLeafValues([15, 13, 5, 3, 15]))
