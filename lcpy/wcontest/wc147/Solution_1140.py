from typing import List
from functools import lru_cache

import functools
print = functools.partial(print, flush=True)

class Solution:
    @staticmethod
    def dump(v):
        print(', '.join([f'{k}: {v}' for k, v in v.items() if k != 'self' and not callable(v)]))

    @staticmethod
    def magic_stone_game_2(piles: List[int]) -> int:
        l = len(piles)
        for i in range(l - 2, -1, -1):
            piles[i] += piles[i + 1]

        print(piles)

        @lru_cache(None)
        def best_move(i, m):
            if i + 2 * m >= l: return piles[i]
            # BRILLIANT!
            # Explanation: Best move yields SUM(piles[i:]) - SUM(best_move(i+1))
            return piles[i] - min(best_move(i + x, max(m, x)) for x in range(1, 2 * m + 1))

        return best_move(0, 1)


    def stoneGameII(self, piles: List[int]) -> int:
        known_best_moves = {}

        @lru_cache(None)
        def best_move(m, piles):
            l = len(piles)
            if m * 2 >= l: return [piles]

            best_start = []
            best_end = []
            most_stones = 0

            for i in range(1, m*2+1):
                start, rest = piles[:i], piles[i:]

                end = best_move(max(i, m), rest)

                stones = sum(start) + sum((sum(s) for i, s in enumerate(end) if i % 2 == 1))

                if stones > most_stones:
                    most_stones = stones
                    print(f'*end: {end}')
                    best_start = start
                    best_end = end

            return [best_start, *best_end]

        best = best_move(1, tuple(piles))
        print(f'Best[TOP]:  {best}')
        return sum(sum(s) for i, s in enumerate(best) if i % 2 == 0)

s = Solution()
v = s.stoneGameII([2, 7, 9, 4, 4, 1, 1, 1, 10, 1, 1, 1, 1, 1, 20])

print(f'v = {v}')

v = s.magic_stone_game_2([2, 7, 9, 4, 4, 1, 1, 1, 10, 1, 1, 1, 1, 1, 20])

print(f'v = {v}')