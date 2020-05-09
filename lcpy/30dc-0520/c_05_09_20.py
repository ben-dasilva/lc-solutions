class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        guess = (num+1) // 2

        last = guess

        while True:
            product = guess * guess

            if product == num:
                return True

            guess = (guess + num/guess + 1) // 2

            if guess == last:
                return False

            last = guess


test_cases = (
    (True, 0),
    (True, 1),
    (False, 2),
    (False, 3),
    (True, 4),
    (False, 14),
    (True, 16),
    (True, 137931274881),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().isPerfectSquare(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:2}, result: {result:2}, input: {args}')
