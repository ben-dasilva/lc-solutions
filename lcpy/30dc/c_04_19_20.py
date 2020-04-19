from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """Suppose an array sorted in ascending order is rotated at some pivot
        unknown to you beforehand.

        (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

        You are given a target value to search. If found in the array return
        its index, otherwise return -1. You may assume no duplicate exists in
        the array.

        Your algorithm's runtime complexity must be in the order of O(log n)."""

        # find pivot
        def find_pivot(l, nums):
            l, m, r = 0, l // 2, l - 1

            while r - l > 1 and nums[l] > nums[r]:
                if nums[l] > nums[m]:
                    m, r = (l + m) // 2, m
                else:
                    l, m = m, (m + r) // 2

            p = r if nums[l] > nums[r] else l

            return p

        size = len(nums)

        if not size:
            return -1

        p = find_pivot(size, nums)

        l, m, r = 0, size // 2, size - 1

        while l <= r:
            shifted_m = (m + p) % size

            if nums[shifted_m] == target:
                return shifted_m

            if target < nums[shifted_m]:
                m, r = (l + m - 1) // 2, m - 1
            else:
                l, m = m + 1, (m + 1 + r) // 2

        shifted_m = (m + p) % size

        return shifted_m if nums[shifted_m] == target else -1


test_cases = (
    (67, [208,
          [266, 267, 268, 269, 271, 278, 282, 292, 293, 298, 6, 9, 15, 19, 21, 26, 33, 35, 37, 38, 39, 46, 49, 54, 65,
           71, 74, 77, 79, 82, 83, 88, 92, 93, 94, 97, 104, 108, 114, 115, 117, 122, 123, 127, 128, 129, 134, 137, 141,
           142, 144, 147, 150, 154, 160, 163, 166, 169, 172, 173, 177, 180, 183, 184, 188, 198, 203, 208, 210, 214, 218,
           220, 223, 224, 233, 236, 241, 243, 253, 256, 257, 262, 263]]),
    (1, [4, [5, 4]]),
    (2, [4, [5, 1, 4]]),
    (3, [4, [5, 1, 2, 4]]),
    (4, [4, [5, 1, 2, 3, 4]]),
    (5, [4, [5, 0, 1, 2, 3, 4]]),
    (6, [4, [5, -1, 0, 1, 2, 3, 4]]),
    (5, [3, [5, -1, 0, 1, 2, 3, 4]]),
    (2, [5, [1, 3, 5]]),
    (1, [3, [1, 3, 5]]),
    (0, [1, [1, 3, 5]]),
    (-1, [0, []]),
    (-1, [0, [2, 1]]),
    (-1, [0, [1, 2]]),
    (0, [2, [2, 1]]),
    (1, [2, [1, 2]]),
    (-1, [0, [2, 3, 1]]),
    (-1, [0, [1, 2, 3]]),
    (-1, [0, [3, 1, 2]]),
    (0, [2, [2, 3, 1]]),
    (1, [2, [1, 2, 3]]),
    (2, [2, [3, 1, 2]]),
    (0, [2, [2, 1]]),
    (1, [2, [1, 2]]),
    (0, [2, [2]]),
    (-1, [2, [1]]),
    (4, [0, [4, 5, 6, 7, 0, 1, 2]]),
    (5, [0, [4, 5, 6, 7, 8, 0, 1, 2, 3]]),
    (-1, [3, [4, 5, 6, 7, 0, 1, 2]]),
)

# unit tests
for pair in test_cases:
    expected, (target, nums) = pair

    result = Solution().search(nums, target)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {target, nums}')
