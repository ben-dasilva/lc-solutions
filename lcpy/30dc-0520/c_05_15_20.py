from typing import List


class Solution:
    def maxSubarraySumCircular(self, A: List[int]) -> int:

        def kadane(nums):
            candidate_start, max_start, max_end = 0, 0, 1

            s, h = 0, nums[0]

            for i, n in enumerate(nums):
                if s < 0:
                    candidate_start = i
                    s = n
                else:
                    s += n

                if s > h:
                    max_start = candidate_start
                    max_end = i
                    h = s

            return h, max_start, max_end

        _, _, end = kadane(list(-a for a in A))

        k_normal, _, _ = kadane(A)
        k_rotated, _, _ = kadane(A[end:] + A[:end])

        return max(k_normal, k_rotated)


test_cases = (
    (3, [1, -2, 3, -2]),
    (10, [5, -3, 5]),
    (4, [3, -1, 2, -1]),
    (3, [3, -2, 2, -3]),
    (-1, [-2, -3, -1]),
    (3, [-2, -3, 1, 2, -1]),
    (20, [-1, 3, -3, 9, -6, 8, -5, -5, -6, 10]),
    (16, [0, 5, 8, -9, 9, -7, 3, -2]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().maxSubarraySumCircular(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:2}, result: {result:2}, input: {args}')
