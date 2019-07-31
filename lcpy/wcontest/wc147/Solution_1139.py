from typing import List

class Solution:
    @staticmethod
    def dump(v):
        print('\n'.join([f'{k}: {v}' for k, v in v.items() if k != 'self']))

    def largest1BorderedSquare(self, grid: List[List[int]]) -> int:
        width  = len(grid[0])
        height = len(grid)

        rmax_grid = [[0]*width for _ in range(height)]
        cmax_grid = [[0]*width for _ in range(height)]

        for rnum in range(height-1, -1, -1):
            for cnum in range(width-1, -1, -1):
                if grid[rnum][cnum]:
                    rmax_grid[rnum][cnum] = 1 if cnum == width-1 else rmax_grid[rnum][cnum+1]+1
                    cmax_grid[rnum][cnum] = 1 if rnum == height-1 else cmax_grid[rnum+1][cnum]+1

        max_square = 0

        for rnum in range(height):
            if height - rnum < max_square: break

            for cnum in range(width):
                if width - cnum < max_square: break

                max_possible = min(rmax_grid[rnum][cnum], cmax_grid[rnum][cnum])

                if max_possible < max_square: continue

                for candidate in range(max_possible-1, max_square-1, -1):
                    if rmax_grid[rnum+candidate][cnum] > candidate and cmax_grid[rnum][cnum+candidate] > candidate:
                        max_square = max(max_square, candidate+1)
                        break

        return max_square*max_square
