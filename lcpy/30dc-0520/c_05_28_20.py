from typing import List


class Solution:
    def countBits(self, num: int) -> List[int]:
        bits = [0]
        idx = 0
        size = 1

        for i in range(num):
            bits.append(bits[idx] + 1)

            if idx == size-1:
                idx = 0
                size <<= 1
            else:
                idx += 1

        return bits


test_cases = (
    ([0], 0),
    ([0, 1], 1),
    ([0, 1, 1], 2),
    ([0, 1, 1, 2], 3),
    ([0, 1, 1, 2, 1, 2], 5),
    ([0, 1, 1, 2, 1, 2, 2, 3], 7),
)

for pair in test_cases:
    expected, n = pair

    result = Solution().countBits(n)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {n}')
