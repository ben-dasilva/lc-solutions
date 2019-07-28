from typing import List

class Solution:
    def maxAbsValExpr(self, arr1: List[int], arr2: List[int]) -> int:
        min1 = min(arr1)
        min2 = min(arr2)
        max1 = max(arr1)
        max2 = max(arr2)

        combined = [[((a - min1) + (b - min2) + i) for i, (a, b) in enumerate(zip(arr1, arr2))],
                    [((max1 - a) + (b - min2) + i) for i, (a, b) in enumerate(zip(arr1, arr2))],
                    [((a - min1) + (max2 - b) + i) for i, (a, b) in enumerate(zip(arr1, arr2))],
                    [((max1 - a) + (max2 - b) + i) for i, (a, b) in enumerate(zip(arr1, arr2))]]

        diff = 0

        for c in combined:
            c.sort()
            diff = max(diff, abs(c[-1] - c[0]))

        return diff
