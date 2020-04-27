from typing import List
import collections


def print_matrix(matrix):
    for r in matrix:
        for c in r:
            print(f'{c:2} ', end='')
        print()


def transpose(matrix) -> List[List[str]]:
    if not matrix:
        return matrix

    l_r = len(matrix)
    l_c = len(matrix[0])
    ret = [[""] * l_r for x in range(l_c)]
    for c in range(l_c):
        for r in range(l_r):
            ret[c][r] = matrix[r][c]
    return ret


class Solution:
    def maximalSquare(self, matrix: List[List[str]], tr=False) -> int:
        """Given a 2D binary matrix filled with 0's and 1's, find the largest
         square containing only 1's and return its area."""
        if not matrix:
            return 0

        h = 0
        l_r = len(matrix)
        l_c = len(matrix[0])

        prev_row = None

        for r in range(l_r - 1, -1, -1):
            curr_row = collections.deque()

            for c in range(l_c - 1, -1, -1):
                last_row = r == l_r - 1
                last_col = c == l_c - 1
                bit = matrix[r][c] == '1'

                lr = 0 if last_row or last_col else prev_row[c + 1]
                right = 0 if last_col else curr_row[0]
                down = 0 if last_row else prev_row[c]

                v: int = 0 if not bit else 1 + min(lr, right, down)
                curr_row.appendleft(v)

                h = max(h, v)

            prev_row = curr_row

        return h * h


test_cases = (
    (4, [["1", "0", "1", "0", "0"],
         ["1", "0", "1", "1", "1"],
         ["1", "1", "1", "1", "1"],
         ["1", "0", "0", "1", "0"]]),
    (0, None),
    (0, []),
    (0, [[]]),
    (1, [["0", "1"],
         ["1", "0"]]),
    (16, [["1", "1", "1", "1", "1", "1", "1", "1"],
          ["1", "1", "1", "1", "1", "1", "1", "0"],
          ["1", "1", "1", "1", "1", "1", "1", "0"],
          ["1", "1", "1", "1", "1", "0", "0", "0"],
          ["0", "1", "1", "1", "1", "0", "0", "0"]]),
    (9, [["0", "0", "0", "1"],
         ["1", "1", "0", "1"],
         ["1", "1", "1", "1"],
         ["0", "1", "1", "1"],
         ["0", "1", "1", "1"]]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().maximalSquare(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input:')
    if args:
        print_matrix(args)
