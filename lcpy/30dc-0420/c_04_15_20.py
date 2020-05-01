from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        """Given an array nums of n integers where n > 1,  return an array
        output such that output[i] is equal to the product of all the
        elements of nums except nums[i]."""

        l = len(nums)
        ret = [1] * l

        # return list acts as temp storage for product of elements to the LEFT of i
        for i in range(1, l):
            ret[i] = nums[i-1] * ret[i-1]

        # then we use a variable to store the product to the RIGHT of i
        prod_right = 1

        for i in range(l-2, -1,-1):
            prod_right *= nums[i+1]
            ret[i] = ret[i] * prod_right

        return ret


test_cases = (
    ([24, 12, 8, 6], [1, 2, 3, 4]),
    ([0, 0], [0, 0]),
    ([0, 1], [1, 0]),
    ([1, 0], [0, 1]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().productExceptSelf(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {args}')
