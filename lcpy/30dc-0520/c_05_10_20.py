from typing import List


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        trusts = [0] * N
        trusted = [0] * N

        for (trusts_, trusted_) in trust:
            trusts[trusts_ - 1] += 1
            trusted[trusted_ - 1] += 1

        candidates = [i for (i, ts, td) in zip(range(N), trusts, trusted) if ts == 0 and td >= N - 1]

        return -1 if len(candidates) != 1 else candidates[0] + 1


test_cases = (
    (-1, 0, []),
    (2, 2, [[1, 2]]),
    (-1, 2, [[1, 2], [1, 2], [2, 2]]),
    (3, 3, [[1, 3], [2, 3]]),
    (-1, 3, [[1, 3], [2, 3], [3, 1]]),
    (-1, 3, [[1, 2], [2, 3]]),
    (3, 4, [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]]),
)

# unit tests
for pair in test_cases:
    expected, n, args = pair

    result = Solution().findJudge(n, args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:2}, result: {result:2}, input: {n, args}')
