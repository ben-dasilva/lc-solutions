from typing import List
import collections

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        majority = len(nums) // 2

        count = collections.defaultdict(int)
        for n in nums:
            count[n] += 1
            if count[n] > majority:
                return n

        return -1


test_cases = (
    (3, [3, 2, 3]),
    (2, [2, 2, 1, 1, 1, 2, 2]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().majorityElement(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:2}, result: {result:2}, input: {args}')
