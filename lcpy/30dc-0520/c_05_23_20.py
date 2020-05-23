from typing import List


class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        flat = []
        flat.extend(((a[0], 0, 0) for a in A))
        flat.extend(((a[1], 1, 0) for a in A))
        flat.extend(((a[0], 0, 1) for a in B))
        flat.extend(((a[1], 1, 1) for a in B))
        flat.sort()

        in_segment = [None, None]

        segments = []

        for e in flat:
            if in_segment[0] and in_segment[1]:
                if e[1]:
                    segments.append([max(in_segment[0][0], in_segment[1][0]), e[0]])

            if e[1]:
                in_segment[e[2]] = None
            else:
                in_segment[e[2]] = e

        return segments


test_cases = (
    ([[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]],
     [[0, 2], [5, 10], [13, 23], [24, 25]],
     [[1, 5], [8, 12], [15, 24], [25, 26]]),
)


def as_list(r):
    return r.as_list() if r else []


# unit tests
for pair in test_cases:
    expected, a, b = pair

    result = Solution().intervalIntersection(a, b)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {a, b}')
