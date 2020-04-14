from typing import List


class Solution:
    def stringShift(self, s: str, shift: List[List[int]]) -> str:
        total = 0

        for direction, amount in shift:
            total += (1 if direction else -1) * amount

        total %= len(s)

        return s[-total:] + s[:-total]


test_cases = (
    ("cab", ("abc", [[0, 1], [1, 2]])),
    ("a", ("a", [[0, 1], [1, 2]])),
    ("bca", ("abc", [[0, 1]])),
    ("efgabcd", ("abcdefg", [[1, 1], [1, 1], [0, 2], [1, 3]])),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().stringShift(args[0], args[1])

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
