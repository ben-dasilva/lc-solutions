class Solution:
    def checkValidString(self, s: str) -> bool:
        high = low = 0

        for c in s:
            if c == '(':
                low += 1
                high += 1
            elif c == ')':
                low = max(0, low - 1)
                high -= 1
            elif c == '*':
                low = max(0, low - 1)
                high += 1

            # print(f'{c} -> [{low}..{high}]')

            if high < 0:
                return False

        return low == 0


test_cases = (
    (False, "((*)(*))((*"),
    (False, "(*)((*"),
    (False, "(())((())()()(*)(*()(())())())()()((()())((()))(*"),
    (False, "*("),
    (True, "()*"),
    (True, "*()"),
    (True, "*)"),
    (False, ")*"),
    (False, "*))"),
    (True, "**))"),
    (True, ""),
    (True, "()"),
    (False, "("),
    (False, ")"),
    (False, ")*"),
    (True, "()()"),
    (True, "(*)"),
    (True, "(*"),
    (True, "*)"),
    (True, "((*)"),
    (True, "(*))"),
    (False, "(*)))"),
    (False, "(((*)"),
    (True, "(((*))"),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().checkValidString(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
