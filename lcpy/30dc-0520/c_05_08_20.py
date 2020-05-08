from typing import List


class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        start = coordinates[0]
        dx = coordinates[1][0] - start[0]
        dy = coordinates[1][1] - start[1]

        if dx == 0:
            return False

        r = dy / dx

        for p in coordinates[2:]:
            dx = p[0] - start[0]
            dy = p[1] - start[1]
            if dx == 0 or dy / dx != r:
                return False

        return True


test_cases = (
    (True, [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7]]),
    (False, [[1, 1], [2, 2], [3, 4], [4, 5], [5, 6], [7, 7]]),
    (False, [[-7, -3], [-7, -1], [-2, -2], [0, -8], [2, -2], [5, -6], [5, -5], [1, 7]]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().checkStraightLine(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:2}, result: {result:2}, input: {args}')
