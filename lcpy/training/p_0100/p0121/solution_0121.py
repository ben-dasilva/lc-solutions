from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 0:
            return 0

        low, high, profit = prices[0], prices[0], 0

        for i in prices:
            if i > high:
                high = i
                profit = max(profit, high - low)
            elif i < low:
                high = low = i

        return profit


s = Solution()

prices = [
    [7, 1, 5, 3, 6, 4],
    [7, 6, 4, 3, 1],
    [10, 12, 21, 1, 9],
    [10, 12, 21, 1, 10],
    [10, 12, 21, 1, 11],
    [10, 12, 21, 1, 12],
    [10, 12, 21, 1, 14],
    [10, 12, 121, 1, 14],
]
for price in prices:
    p = s.maxProfit(price)
    print(f'Profit: {p} ({price})')
