from typing import List
import collections


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        original = image[sr][sc]

        if original == newColor:
            return image
        else:
            image[sr][sc] = newColor

        l_r, l_c = len(image), len(image[0])
        not_yet_visited = collections.deque()
        not_yet_visited.append((sr, sc))

        while not_yet_visited:
            nr, nc = not_yet_visited.pop()

            for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                n_r, n_c = nr + dr, nc + dc
                if 0 <= n_r < l_r and 0 <= n_c < l_c and image[n_r][n_c] == original:
                    image[n_r][n_c] = newColor
                    not_yet_visited.append((n_r, n_c))

        return image


test_cases = (
    ([[2, 2, 2], [2, 2, 0], [2, 0, 1]], 1, 1, 2, [[1, 1, 1], [1, 1, 0], [1, 0, 1]]),
    ([[0, 0, 0], [0, 2, 0]], 1, 1, 2, [[0, 0, 0], [0, 1, 0]]),
    ([[0, 0, 0], [0, 1, 1]], 1, 1, 1, [[0, 0, 0], [0, 1, 1]]),
)

# unit tests
for pair in test_cases:
    expected, r, c, new_color, args = pair

    result = Solution().floodFill(args, r, c, new_color)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {args}')
