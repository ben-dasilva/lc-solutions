class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        common = set(word1).intersection(word2)

        len_1 = len(word1)
        len_2 = len(word2)

        known_distance = {}

        def min_dist(s1, s2):
            if s1 == len_1 or s2 == len_2:
                return max(len_1 - s1, len_2 - s2)

            key = s1, s2

            if key in known_distance:
                return known_distance[key]

            min_d = len_1 + len_2

            same_char = word1[s1] == word2[s2]

            if same_char:
                min_d = min_dist(s1 + 1, s2 + 1)

            if same_char or word1[s1] in common:
                min_d = min(min_d, 1 + min_dist(s1, s2 + 1))

            if same_char or word2[s2] in common:
                min_d = min(min_d, 1 + min_dist(s1 + 1, s2))

            min_d = min(min_d, 1 + min_dist(s1 + 1, s2 + 1))

            known_distance[key] = min_d

            return min_d

        return min_dist(0, 0)


test_cases = (
    (3, "horse", "ros"),
    (5, "intention", "execution"),
)

for pair in test_cases:
    expected, w1, w2 = pair

    result = Solution().minDistance(w1, w2)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {w1, w2}')
