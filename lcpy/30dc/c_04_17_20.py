from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        """Given a 2d grid map of '1's (land) and '0's (water), count the
        number of islands. An island is surrounded by water and is formed
        by connecting adjacent lands horizontally or vertically. You may
        assume all four edges of the grid are all surrounded by water."""
        if not grid or not grid[0]:
            return 0

        height = len(grid)
        width  = len(grid[0])
        visited = [[False for i in range(width)] for j in range(height)]

        islands = 0

        def explore_island(i, j):
            if visited[i][j] or grid[i][j] == '0':
                return

            visited[i][j] = True

            if i > 0:
                explore_island(i - 1, j)
            if i < height-1:
                explore_island(i + 1, j)
            if j > 0:
                explore_island(i, j - 1)
            if j < width-1:
                explore_island(i, j + 1)

        for i in range(height):
            for j in range(width):
                if visited[i][j] or grid[i][j] == '0':
                    continue
                # start exploring island
                explore_island(i, j)
                islands += 1

        return islands


test_cases = (
    (0, [[]]),
    (0, []),
    (0, None),
    (1, [["1"]]),
    (0, [["0"]]),
    (1, [["1", "1"]]),
    (0, [["0", "0"]]),
    (1, [["1", "1", "1", "1", "0"],
         ["1", "1", "0", "1", "0"],
         ["1", "1", "0", "0", "0"],
         ["0", "0", "0", "0", "0"]]),
    (3, [["1", "1", "0", "0", "0"],
         ["1", "1", "0", "0", "0"],
         ["0", "0", "1", "0", "0"],
         ["0", "0", "0", "1", "1"]]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().numIslands(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
