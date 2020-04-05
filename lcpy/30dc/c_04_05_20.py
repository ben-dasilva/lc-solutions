from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """Find maximum profit from price list.

        Say you have an array for which the ith element is the price of a given stock on day i.
        Design an algorithm to find the maximum profit. You may complete as many transactions
        as you like (i.e., buy one and sell one share of the stock multiple times).
        Note: You may not engage in multiple transactions at the same time (i.e., you must sell
        the stock before you buy again)."""

        profit, cost = 0, 0
        own = False

        for today, tomorrow in zip(prices, prices[1:] + [0]):
            if own and today > tomorrow:
                # Sell
                profit += today - cost
                own = False
            elif not own and today < tomorrow:
                # Buy
                cost = today
                own = True

        return profit


test_cases = (
    (7, [7, 1, 5, 3, 6, 4]),
    (4, [1, 2, 3, 4, 5]),
    (0, [7, 6, 4, 3, 1]),
    (0, [1]),
    (1, [1, 2]),
    (0, [2, 1]),
    (0, [2, 2]),
    (2, [1, 2, 1, 0, 1]),
)

# unit tests
for pair in test_cases:
    expected, args = pair

    result = Solution().maxProfit(args)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result:3}, input: {args}')
