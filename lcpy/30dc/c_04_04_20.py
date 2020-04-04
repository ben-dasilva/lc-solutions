from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        first_zero = 0

        size = len(nums)

        while first_zero < size - 1 and nums[first_zero] != 0:
            first_zero += 1

        for i in range(first_zero + 1, size):
            if nums[i] != 0:
                nums[first_zero], nums[i] = nums[i], 0
                first_zero += 1


test_cases = (
    ([0, 1, 0, 3, 12], [1, 3, 12, 0, 0]),
    ([1, 2, 0, 3, 12], [1, 2, 3, 12, 0]),
    ([1], [1]),
    ([0], [0]),
    ([], []),
    ([0, 1], [1, 0]),
    ([1, 0], [1, 0]),
)

# unit tests
for pair in test_cases:
    args, expected = pair
    original = list(args)

    Solution().moveZeroes(args)

    message = "OK" if args == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {args}, input: {original}')
