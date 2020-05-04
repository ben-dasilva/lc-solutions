class Solution:
    def findComplement(self, num: int) -> int:
        mask = 0

        i = num

        while i > 0:
            mask <<= 1
            mask |= 1
            i >>= 1

        return mask & ~num


test_cases = (
    (0, 1),
    (1, 2),
    (2, 5),
    (0, 7),
    (3260, 13123),
)

# Input:  11001101000011
# Output: ..110010111100

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().findComplement(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:32b}, result: {result:32b}, input: {args:32b}')
