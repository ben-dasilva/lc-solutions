from unittest import TestCase
from wcontest.wc148.Solution_1144 import Solution


class TestSolution(TestCase):
    def test_123(self):
        s = Solution()
        v = s.movesToMakeZigzag([1, 2, 3])
        self.assertEqual(2, v)

    def test_9_6_1(self):
        s = Solution()
        v = s.movesToMakeZigzag([9, 6, 1, 6, 2])
        self.assertEqual(4, v)

    def test_2_7_10(self):
        s = Solution()
        v = s.movesToMakeZigzag([2, 7, 10, 9, 8, 9])
        self.assertEqual(4, v)
