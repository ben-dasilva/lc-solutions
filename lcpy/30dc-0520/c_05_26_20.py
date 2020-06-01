from typing import List


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        h = 0

        c = 0
        first_seen = {0: -1}

        for i, n in enumerate(nums):
            c += 1 if n else -1
            if c in first_seen:
                h = max(h, i - first_seen[c])
            else:
                first_seen[c] = i

        return h


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
