from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        """Given an array of non-negative integers, you are initially positioned
        at the first index of the array. Each element in the array represents
        your maximum jump length at that position. Determine if you are able to
        reach the last index."""
        r = 0

        for i in range(len(nums) - 1):
            r = max(r, i + nums[i])
            if r == i:
                return False

        return True


test_cases = (
    (True, [2, 3, 1, 1, 4]),
    (True, [2, 3, 1, 1, 4, 0]),
    (False, [3, 2, 1, 0, 4]),
    (True, [100]),
    (False, [0, 100]),
    (True, [100, 100]),
    (True, [0]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().canJump(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
