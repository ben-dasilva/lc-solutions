class Solution:
    def isHappy(self, n: int) -> bool:
        known = {1: True}

        def square_of_digits(n_: int) -> int:
            digits = []

            while n_ > 0:
                digits.append(n_ % 10)
                n_ //= 10

            return sum(d * d for d in digits)

        def cached_happy(visited, n_) -> bool:
            if n_ in known:
                return known[n_]

            is_happy = False

            if n_ not in visited:
                visited.add(n_)
                is_happy = cached_happy(visited, square_of_digits(n_))

            known[n_] = is_happy

            return is_happy

        return cached_happy(set(), n)


tests = (
    (19, True),
    (2, False),
    (3, False),
    (8, False),
    (9, False),
    (10, True),
    (7, True)
)

for pair in tests:
    result = Solution().isHappy(pair[0])
    print(f'isHappy({pair[0]}) -> {result} (expected: {pair[1]})')
