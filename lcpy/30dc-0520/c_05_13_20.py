class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        s = [num[0]]

        i = 1
        while k and i < len(num):
            if s and s[-1] > num[i]:
                s.pop()
                k -= 1
            else:
                s.append(num[i])
                i += 1

        num = ("".join(s[:-k] if k else s) + num[i:]).lstrip('0')

        return num if num else '0'


test_cases = (
    ("19", "219", 1),
    ("19", "2219", 2),
    ("1", "2219", 3),
    ("21898", "2221898", 2),
    ("1219", "1432219", 3),
    ("200", "10200", 1),
    ("0", "10", 1),
    ("0", "10", 2),
)

# unit tests
for pair in test_cases:
    expected, num, k = pair

    result = Solution().removeKdigits(num, k)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected}, result: "{result}", input: {num, k}')
