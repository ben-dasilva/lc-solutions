from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        while prerequisites:
            sources = set(x for x, y in prerequisites)
            targets = set(y for x, y in prerequisites)

            diff = sources.symmetric_difference(targets)

            if not diff:
                return False

            prerequisites = list((x, y) for x, y in prerequisites if x not in diff and y not in diff)

        return True


test_cases = (
    (True, 2, []),
    (True, 2, [[1, 0]]),
    (False, 2, [[1, 0], [0, 1]]),
    (True, 3, [[1, 0], [1, 2], [2, 0]]),
    (True, 3, [[1, 0], [2, 1], [3, 2], [4, 3]]),
    (False, 3, [[0, 2], [1, 2], [2, 0]]),
    (True, 8, [[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]),
)

for pair in test_cases:
    expected, n, prereq = pair

    result = Solution().canFinish(n, prereq)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {n, prereq}')
