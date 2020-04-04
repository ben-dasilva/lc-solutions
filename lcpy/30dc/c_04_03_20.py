from typing import List


class Solution:
    """Given an integer array nums, find the contiguous subarray
     (containing at least one number) which has the largest sum
     and return its sum."""

    def maxSubArray(self, nums: List[int]) -> int:
        m = nums[0]
        candidate = 0

        for n in nums:
            candidate = max(n, candidate + n)
            m = max(m, candidate)

        return m


test_cases = (
    (6, [-2, 1, -3, 4, -1, 2, 1, -5, 4]),
    (3, [1, 1, 1]),
    (1, [1]),
    (-1, [-1]),
    (-1, [-1, -2]),
    (-1, [-2, -1]),
    (0, [0]),
    (11, [5, -1, 7]),
    (7, [5, -6, 7]),
    (8, [5, -1, -1, -2, 7]),
    (8, [-1, 5, -1, -1, -2, 7, -1]),
    (5, [-1, 5, -1]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().maxSubArray(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
