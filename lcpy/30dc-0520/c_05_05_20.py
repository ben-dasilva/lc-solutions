import collections


class Solution:
    def firstUniqChar(self, s: str) -> int:
        first_pos = {}
        all_pos = collections.defaultdict(int)

        for i, c in enumerate(s):
            count = all_pos[c]

            all_pos[c] = count + 1

            if count == 0:
                first_pos[c] = i
            elif c in first_pos:
                del first_pos[c]

        if first_pos:
            return next(iter(first_pos.values()))

        return -1


test_cases = (
    (0, "leetcode"),
    (2, "loveleetcode"),
    (0, "abc"),
    (-1, "abcabc"),
    (-1, "aadadaad"),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().firstUniqChar(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:2}, result: {result:2}, input: {args}')
