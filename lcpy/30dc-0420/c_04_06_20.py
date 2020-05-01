import collections
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """Given an array of strings, group anagrams together."""

        anagrams = collections.defaultdict(list)
        for word in strs:
            anagrams[''.join(sorted(word))].append(word)

        return [sorted(words) for words in anagrams.values()]


test_cases = (
    ([["ate", "eat", "tea"], ["nat", "tan"], ["bat"]], ["eat", "tea", "tan", "ate", "nat", "bat"]),
    ([["1"], ["123", "213", "312", "321"]], ["1", "123", "321", "213", "312"])
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().groupAnagrams(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: {result}, input: {args}')
