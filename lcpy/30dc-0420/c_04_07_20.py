from typing import List


class Solution:
    def countElements(self, arr: List[int]) -> int:
        """Given an integer array arr, count element x such that x + 1 is also in arr.
        If there're duplicates in arr, count them seperately."""
        return sum(1 for n in arr if n in {n - 1 for n in arr})


test_cases = (
    (0, [1, 1, 3, 3, 5, 5, 7, 7]),
    (3, [1, 3, 2, 3, 5, 0]),
    (2, [1, 1, 2, 2]),
    (0, [1]),
    (0, [1, 1]),
    (0, [1, 1, 4]),
    (2, [1, 1, 2]),
    (1, [1, 2, 2]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().countElements(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
