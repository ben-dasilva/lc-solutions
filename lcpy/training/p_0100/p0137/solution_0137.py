from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        c = [0, 0]

        for i in nums:
            c[1], c[0] = i & c[0] | ~i&c[1], i & ~(c[0]|c[1]) | ~i &c[0]
            print(f'    {i:#08b} => ... c: {c[1]:#010b}, {c[0]:#010b}')

        print(f'c: {c[1]:#010b}, {c[0]:#010b}')

        return c[0]


s = Solution()

for i in ([2, 2, 6, 2], [2, 11, 11, 2, 11, 2, 4]):
    print(f'Series: {i}, odd one out: {s.singleNumber(i)}')