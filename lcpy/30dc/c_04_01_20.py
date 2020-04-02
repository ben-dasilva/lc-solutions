from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        oddOne = 0
        for n in nums:
            oddOne ^= n
        return oddOne


print(f'Result: {Solution().singleNumber([1, 2, 5, 3, 2, 1, 3])}')
print(f'Result: {Solution().singleNumber([2, 2, 1])}')
print(f'Result: {Solution().singleNumber([4,1,2,1,2])}')
print(f'Result: {Solution().singleNumber([-4,1,2,1,2])}')
