import time


class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        """Given a range [m, n] where 0 <= m <= n <= 2147483647, return the
         bitwise AND of all numbers in this range, inclusive."""
        ret = 0x1fffffffffffff

        for i in range(m, n+1):
            ret &= i

        return ret

    def better_range_bitwise_and(self, m: int, n: int) -> int:
        """Given a range [m, n] where 0 <= m <= n <= 2147483647, return the
         bitwise AND of all numbers in this range, inclusive."""

        mask = (m ^ n)

        b = 0
        while mask:
            b <<= 1
            b |= 1
            mask >>= 1

        return n & ~b

test_cases = (
    (4, (5, 7)),
    (0, (0, 1)),
    (5, (5, 5)),
    (10, (10, 11)),
    (96, (99, 127)),
    (112, (115, 127)),
    (0, (99, 128)),
    (0, (128, 0x1ffff)),
)

# unit tests
def ut(fn):
    print(fn.__name__)
    for pair in test_cases:
        expected, (first, last) = pair

        start = time.time()
        result = fn(first, last)
        elapsed = (time.time() - start) * 1000

        message = "OK" if result == expected else "ERROR"

        print(f'{message:6}: expected: {expected:b}, result: {result:b}, input: [{first:b}..{last:b}].'
              f' ({elapsed:2.6f} ms)')


ut(Solution().rangeBitwiseAnd)
ut(Solution().better_range_bitwise_and)
