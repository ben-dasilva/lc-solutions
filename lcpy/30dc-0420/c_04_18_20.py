from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        """Given a m x n grid filled with non-negative numbers, find a path
        from top left to bottom right which minimizes the sum of all numbers
         along its path.

        Note: You can only move either down or right at any point in time."""

        if not grid or not grid[0]:
            return 0

        n_rows = len(grid)
        n_cols = len(grid[0])

        # all nodes start as "unvisited"
        grid_sum = [[-1 for x in range(n_cols)] for x in range(n_rows)]

        # initial node: (0, 0)
        grid_sum[0][0] = grid[0][0]

        # destination node: (n_rows-1, n_cols-1)
        dest = n_rows - 1, n_cols - 1

        row, col = 0, 0

        while (row, col) != dest:
            # at MOST, 2 possible moves: right or down
            curr_sum = grid_sum[row][col]

            # right
            if col + 1 < n_cols:
                adjacent_sum = grid_sum[row][col + 1]
                adjacent_val = grid[row][col + 1]

                if adjacent_sum < 0 or adjacent_sum > curr_sum + adjacent_val:
                    grid_sum[row][col + 1] = curr_sum + adjacent_val

            # down
            if row + 1 < n_rows:
                adjacent_sum = grid_sum[row + 1][col]
                adjacent_val = grid[row + 1][col]

                if adjacent_sum < 0 or adjacent_sum > curr_sum + adjacent_val:
                    grid_sum[row + 1][col] = curr_sum + adjacent_val

            if col < n_cols - 1:
                col += 1
            else:
                row += 1
                col = 0

        return grid_sum[-1][-1]


# ... a MUCH more elegant solution found online (reuses input parameter memory, though)
class BetterSolution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0

        n_rows, n_cols = len(grid), len(grid[0])

        # pre-calculate sums for first row and first column
        for i in range(1, n_cols):
            grid[0][i] = grid[0][i] + grid[0][i - 1]
        for j in range(1, n_rows):
            grid[j][0] = grid[j][0] + grid[j - 1][0]

        # ... then go row by row replacing existing grid value with lowest of the
        # 2 sums: either the neighbors above or on the left
        for i in range(1, n_rows):
            for j in range(1, n_cols):
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])

        return grid[-1][-1]


test_cases = (
    (0, [[]]),
    (0, []),
    (0, None),
    (1, [[1]]),
    (0, [[0]]),
    (2, [[1, 1]]),
    (0, [[0, 0]]),
    (7, [
        [1, 3, 1],
        [1, 5, 1],
        [4, 2, 1]
    ]),
    (26, [
        [1, 3, 1, 1, 5, 7],
        [1, 5, 1, 5, 9, 3],
        [4, 2, 1, 4, 1, 2],
        [1, 3, 1, 1, 5, 7],
        [1, 5, 1, 5, 9, 3],
        [4, 2, 1, 4, 1, 2],
        [1, 3, 1, 1, 5, 7],
        [1, 5, 1, 5, 9, 3],
        [4, 2, 1, 4, 1, 2],
        [1, 3, 1, 1, 5, 7],
        [1, 5, 1, 5, 9, 3],
        [4, 2, 1, 4, 1, 2],
        [1, 3, 1, 1, 5, 7],
        [1, 5, 1, 5, 9, 3],
        [4, 2, 1, 4, 1, 2],
    ]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = BetterSolution().minPathSum(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
