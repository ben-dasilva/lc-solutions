import collections


class Solution:
    def frequencySort(self, s: str) -> str:
        c = collections.Counter(s)
        return ''.join(a*i for a,i in sorted(c.items(), key=lambda x: x[1], reverse=True))


print(Solution().frequencySort("ttrrrrrrreeee"))