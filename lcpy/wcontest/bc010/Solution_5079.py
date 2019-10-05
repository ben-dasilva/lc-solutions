from typing import List


class Solution:
    def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:
        s1 = set(arr1)
        s2 = set(arr2)
        s3 = set(arr3)
        return sorted(list(s1.intersection(s2).intersection(s3)))


def test_01():
    s = Solution()
    result = s.arraysIntersection([1, 2, 3, 4, 5], [1, 2, 5, 7, 9], [1, 3, 4, 5, 8])
    print(result)


def test_02():
    s = Solution()
    result = s.arraysIntersection([1, 2, 3, 4, 5, 7], [], [1, 3, 4, 5, 8])
    print(result)


test_01()
test_02()
