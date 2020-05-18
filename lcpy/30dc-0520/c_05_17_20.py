from typing import List
import collections

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        size = len(p)

        if len(s) < size or len(s) < 1:
            return []

        expected_counts = collections.Counter(p)
        expected_chars = sum(expected_counts.values())

        chars = expected_chars
        counts = dict(expected_counts)

        ret = []

        for i, c in enumerate(s):
            first_pos = i - size + chars
            #print(f'[{i:2}]:({chars:2}) "{c}" -> "{s[max(0, first_pos):i + 1]}"')

            if c not in counts:
                # we ran out of this char, so this fragment can't be an anagram
                if chars != expected_chars:
                    chars = expected_chars
                    counts = dict(expected_counts)
                continue

            if counts[c] == 0:
                # we ran out of this char... reset counters (partially)
                for j in range(first_pos, len(s)):
                    this_c = s[j]
                    if this_c == c:
                        break
                    chars += 1
                    counts[this_c] += 1
                continue

            counts[c] -= 1
            chars -= 1

            if chars == 0:
                #print(f'    --> ANAGRAM Match!')
                ret.append(first_pos)
                chars = 1
                counts[s[first_pos]] = 1
#            else:
#                print(f'    --> not there yet... missing: {chars}, counter: {counts}')

        return ret


test_cases = (
    ([0, 6], "cbaebabacd", "abc"),
    ([0, 1, 2], "abab", "ab"),
    ([], "aaaaaaa", "ab"),
    ([], "a", "ab"),
    ([0, 1, 2, 3, 4], "aaaaa", "a"),
    ([1, 2, 3, 5], "abacbabc", "abc"),
)

# unit tests
for pair in test_cases:
    expected, large, small = pair

    result = Solution().findAnagrams(large, small)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {large, small}')
