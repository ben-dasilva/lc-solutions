# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

theBad = 4

def isBadVersion(n):
    return n >= theBad


class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        l, r = 1, n

        known_bad = 0

        while l <= r:
            m = (l + r) // 2

            if isBadVersion(m):
                known_bad = m
                r = m-1
            else:
                l = m+1

        return known_bad



test_cases = (
    (1, [1, 1]),
    (4, [4, 10]),
    (1, [1, 10]),
    (1, [1, 10]),
    (9, [9, 10]),
    (0, [11, 10]),
)

# unit tests
for pair in test_cases:
    expected, (theBad, size) = pair

    result = Solution().firstBadVersion(size)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result}, input: {pair}')
