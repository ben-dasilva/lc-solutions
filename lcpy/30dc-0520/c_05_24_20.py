from typing import List
import collections


class Solution:
    def maxUncrossedLines(self, A: List[int], B: List[int]) -> int:
        known_max = {}

        def build_pos(a_list: List[int]) -> dict:
            ret = collections.defaultdict(list)
            for i, e in enumerate(a_list):
                ret[e].append(i)
            return ret

        b_pos = build_pos(B)

        def mul(a_start, b_start) -> int:
            if a_start == len(A) or b_start == len(B):
                return 0

            key = (a_start, b_start)

            if key in known_max:
                return known_max[key]

            a_value = A[a_start]

            if a_value not in b_pos:
                next_b_start = -1
            else:
                next_b_start = ([x for x in b_pos[a_value] if x >= b_start] or [-1])[0]

            if next_b_start < 0:
                ret = mul(a_start + 1, b_start)
            else:
                #print(f"[{a_value}]: {a_start}--{next_b_start}")
                ret = max(mul(a_start + 1, b_start), 1 + mul(a_start + 1, next_b_start + 1))

            known_max[key] = ret

            return ret

        return mul(0, 0)


test_cases = (
    (9, [3, 1, 4, 1, 1, 3, 5, 1, 2, 2], [4, 1, 5, 2, 1, 1, 1, 5, 3, 1, 1, 1, 2, 3, 1, 4, 3, 5, 5, 3, 1, 2, 3, 2, 4, 1, 1, 1, 5, 3]),
    (3, [2, 5, 1, 2, 5], [10, 5, 2, 1, 5, 2]),
    (2, [1, 3, 7, 1, 7, 5], [1, 9, 2, 5, 1]),
    (2, [1, 4, 2], [1, 2, 4]),
)

for pair in test_cases:
    expected, a, b = pair

    result = Solution().maxUncrossedLines(a, b)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result}, input: {a, b}')
