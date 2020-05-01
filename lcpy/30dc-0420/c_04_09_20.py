class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        """Given two strings S and T, return if they are equal when both are
        typed into empty text editors. A '#' means a backspace character."""
        sp, tp = len(S) - 1, len(T) - 1
        sb, tb = 0, 0

        while sp >= 0 or tp >= 0:
            if sp >= 0 and S[sp] == '#':
                sb += 1
                sp -= 1
                continue

            if tp >= 0 and T[tp] == '#':
                tb += 1
                tp -= 1
                continue

            if sb:
                sb -= 1
                sp = -1 if sp < 0 else sp - 1
                continue

            if tb:
                tb -= 1
                tp = -1 if tp < 0 else tp - 1
                continue

            if sp < 0 or tp < 0 or S[sp] != T[tp]:
                return False

            sp -= 1
            tp -= 1

        return True


test_cases = (
    (True, ["a", "a"]),
    (False, ["a", "b"]),
    (False, ["a", "aa"]),
    (False, ["aa", "a"]),
    (False, ["aa", "ab"]),
    (True, ["aa#b", "ab"]),
    (True, ["aa", "ab#a"]),
    (False, ["aa", "123##aa"]),
    (True, ["aa", "12##aa"]),
    (False, ["123##aa", "aa"]),
    (True, ["12##aa", "aa"]),
    (True, ["ab##", "c#d#"]),
    (True, ["c#d#", "ab##"]),
    (True, ["a##c", "#a#c"]),
)

for pair in test_cases:
    expected, args = pair

    result = Solution().backspaceCompare(args[0], args[1])

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
