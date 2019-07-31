from typing import List

class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        def best_move(player, m, piles):
            if m * 2 >= len(piles):
                return len(piles)
            else:
                max_stones = 0
                max_stones

                for i in range(1, min(len(piles), m*2)+1):
                    stones1 = sum(piles[:i])
                    stones2, x = best_move(1 - player, i, piles[i:])

                    if stones1 + stones2 > max_stones:
                        max_stones = stones1 + stones2
                        max_x = x

                return max_stones, max_x


        m = 1
        return best_move(0, m, [*piles])
