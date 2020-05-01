from typing import List


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        """Given a binary array, find the maximum length of a contiguous subarray
         with equal number of 0 and 1."""

        longest = 0
        count = 0
        start = {0: -1}

        for i, bit in enumerate(nums):
            count += 1 if bit else -1

            if count not in start:
                start[count] = i
            else:
                longest = max(longest, i - start[count])

        return longest


test_cases = (
    (2, [0, 1]),
    (2, [0, 1, 0]),
    (0, []),
    (0, [0]),
    (0, [1]),
    (4, [1, 1, 0, 0, 1]),
    (4, [0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1]),
    (6, [0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().findMaxLength(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
