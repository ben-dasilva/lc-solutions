from typing import List


class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        if not matrix or not matrix[0]:
            return 0

        ncols = len(matrix[0])

        prev_row = [0] * ncols

        count = 0
        for row in matrix:
            this_row = list(prev_row)

            for i in range(ncols):
                cell = row[i]
                if i == 0:
                    this_row[i] = cell
                else:
                    this_row[i] = min(this_row[i - 1], prev_row[i], prev_row[i - 1]) + 1 if cell else 0
                count += this_row[i]

            prev_row = this_row

        return count


test_cases = (
    (10, [
        [1, 1, 1, 0],
        [0, 1, 1, 1],
        [0, 0, 1, 1]]),
    (15, [[0, 1, 1, 1],
          [1, 1, 1, 1],
          [0, 1, 1, 1]]),
    (7, [[1,0,1],
        [1,1,0],
        [1,1,0]]),
    (0, None),
    (0, []),
    (0, [[]]),
)

def print_matrix(matrix):
    for r in matrix:
        for c in r:
            print(f'{c:1} ', end='')
        print()


# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().countSquares(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input:')
    if args and len(args) < 10:
        print_matrix(args)
