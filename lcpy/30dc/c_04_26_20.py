class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        """Given two strings text1 and text2, return the length of their
        longest common subsequence."""

        l = [[-1] * len(text2) for x in range(len(text1))]

        def longest(i: int, j: int) -> int:
            if i < 0 or j < 0:
                return 0

            if l[i][j] >= 0:
                return l[i][j]

            if text1[i] == text2[j]:
                l[i][j] = longest(i-1, j-1) + 1
            else:
                l[i][j] = max(longest(i-1, j), longest(i, j-1))

            return l[i][j]

        return longest(len(text1)-1, len(text2)-1)


test_cases = (
    (1, ["a", "a"]),
    (0, ["a", "b"]),
    (1, ["ab", "ba"]),
    (2, ["ab", "ab"]),
    (3, ["abc", "abc"]),
    (3, ["abcde", "ace"]),
    (0, ["abcde", "xyzin2"]),
    (2, ["abcde", "xayzine2"]),
    (5, ["abcde", "abcde"]),
    (3, ["abcde", "ace"]),
    (2, ["oxcpqrsvwf", "shmtulqrypy"]),
    (1, ["bsbininm", "jmjkbkjkv"]),
    (6, ["mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"]),
)

# unit tests
for pair in test_cases:
    expected, (a, b) = pair

    result = Solution().longestCommonSubsequence(a, b)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {a, b}')
