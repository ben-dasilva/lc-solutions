import collections


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:

        magazineLetters = collections.Counter(magazine)

        for r in ransomNote:
            if not magazineLetters[r]:
                return False

            magazineLetters[r] -= 1

        return True
