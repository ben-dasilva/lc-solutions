from typing import List


class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1

        while l < r:
            m = (l + r) // 2

            is_even = m % 2 == 0
            pair_matches = nums[m] == nums[m + 1]

            if is_even ^ pair_matches:
                r = m
            else:
                l = m + 1

        return nums[l]


test_cases = (
    (2, [1, 1, 2, 3, 3]),
    (4, [4]),
    (4, [1, 1, 4]),
    (4, [4, 1, 1]),
    (4, [1, 1, 2, 2, 3, 3, 4]),
    (2, [1, 1, 2, 3, 3, 4, 4, 8, 8]),
    (10, [3, 3, 7, 7, 10, 11, 11]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().singleNonDuplicate(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:2}, result: {result:2}, input: {args}')
