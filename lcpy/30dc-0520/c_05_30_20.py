from typing import List


class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        if len(points) <= K:
            return points

        p_dist = sorted((p[0] * p[0] + p[1] * p[1], p) for p in points)

        return list(p[1] for p in p_dist[:K])


test_cases = (
    ([[-2, 2]], [[1, 3], [-2, 2]], 1),
    ([[3, 3], [-2, 4]], [[3, 3], [5, -1], [-2, 4]], 2),
)

for pair in test_cases:
    expected, point_list, k = pair

    result = Solution().kClosest(point_list, k)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {k, point_list}')
