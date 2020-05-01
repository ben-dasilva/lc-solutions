from typing import List
import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        n_stones = [-s for s in stones]
        heapq.heapify(n_stones)
        c = 0

        while n_stones:
            top = heapq.heappop(n_stones)

            if not n_stones:
                return -top

            another = heapq.heappop(n_stones)
            c = top-another

            if c:
                heapq.heappush(n_stones, c)

        return -c


test_cases = (
    (1, [2,7,4,1,8,1]),
    (1, [1]),
    (2, [2]),
    (0, []),
    (10, [12, 1, 1]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().lastStoneWeight(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')