from typing import List


# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
# class BinaryMatrix(object):
#    def get(self, x: int, y: int) -> int:
#    def dimensions(self) -> list[]:

class BinaryMatrix:
    def __init__(self, m):
        self.matrix = [list(reversed(m_)) for m_ in m]

        self.rows, self.cols = len(self.matrix), len(self.matrix[0])

    def get(self, x: int, y: int) -> int:
        return self.matrix[x][self.cols - y - 1]

    def dimensions(self) -> List[int]:
        return [self.rows, self.cols]


class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        rows, cols = binaryMatrix.dimensions()
        possible_rows = set(i for i in range(rows))

        l, r = 0, cols - 1

        leftmost_one = cols
        rightmost_zero = -1

        while r >= l and rightmost_zero != leftmost_one + 1:
            m = (r + l) // 2

            rejected = set()

            ones = 0

            for r_num in possible_rows:
                if binaryMatrix.get(r_num, m):
                    ones += 1
                    leftmost_one = min(leftmost_one, m)
                elif leftmost_one < m:
                    rejected.add(r_num)

            if not ones:
                rightmost_zero = max(rightmost_zero, m)
                l = m + 1
            else:
                r = m - 1

            possible_rows.difference_update(rejected)

        return -1 if leftmost_one == cols else leftmost_one


test_cases = (
    (-1, [[0]]),
    (-1, [[0, 0], [0, 0]]),
    (0, [[1]]),
    (-1, [[0]]),
    (0, [[1, 1]]),
    (-1, [[0, 0]]),
    (1, [[0, 1, 1]]),
    (1, [[0, 1, 1, 1]]),
    (1, [[0, 1, 1, 1, 1]]),
    (-1, [[0, 0, 0, 0, 0]]),
    (4, [[0, 0, 0, 0, 1]]),
    (3, [[0, 0, 0, 1, 1]]),
    (2, [[0, 0, 1, 1, 1]]),
    (1, [[0, 1, 1, 1, 1]]),
    (0, [[1, 1, 1, 1, 1]]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().leftMostColumnWithOne(BinaryMatrix(args))

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
