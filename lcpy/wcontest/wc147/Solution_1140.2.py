from typing import List


class Solution:
    @staticmethod
    def dump(v):
        print(', '.join([f'{k}: {v}' for k, v in v.items() if k != 'self' and not callable(v)]))

    def stoneGameII(self, piles: List[int]) -> int:
        psum = []

        for i in range(len(piles)-2, -1, -1):
            psum[i] = piles[i] + psum[i+1]

        def best_option(m, p):
            if m*2 >= len(piles) - p:
                return psum[p]

            return max(psum[p] - best_option(max(x, m), psum[p+x]) for x in range(1, 2*m+1))

        return best_option(1, len(piles)-1)

s = Solution()
v = s.stoneGameII([2, 7, 9, 4, 4, 1, 1, 1, 10, 1, 1, 1, 1, 1, 20])

print(f'v = {v}')
