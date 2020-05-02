class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        jewels = set(j for j in J)

        return sum(1 for s in S if s in jewels)

