import collections


class StockSpanner:

    def __init__(self):
        self.count = 0
        self.p_pos = {}
        self.q = collections.deque()
        self.h = -1
        self.l = 1e12
        pass

    def next(self, price: int) -> int:
        self.count += 1

        if price > self.h:
            self.q = collections.deque()
            self.h = price
            self.l = price
            self.q.appendleft(price)
            self.p_pos = {price: self.count}

            return self.count

        self.p_pos[price] = self.count
        while self.q and price > self.q[0]:
            self.q.popleft()

        self.q.appendleft(price)

        if price < self.l:
            self.l = price
            return 1

        # find first predecessor higher than this price
        for e in self.q:
            if e > price:
                return self.count - self.p_pos[e]

        return self.count


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)

null = None

test_cases = (
    ([null, 1, 1, 1, 2, 1, 4, 6], [["StockSpanner", "next", "next", "next", "next", "next", "next", "next"],
                                   [[], [100], [80], [60], [70], [60], [75], [85]]]),

    ([null, 1, 1, 1, 2, 1, 4, 6, 1, 2],
     [["StockSpanner", "next", "next", "next", "next", "next", "next", "next", "next", "next"],
      [[], [100], [80], [60], [70], [60], [75], [85], [1], [65]]]),

    ([null, 1, 1, 3, 4, 5, 6, 7, 8, 9, 10],
     [["StockSpanner", "next", "next", "next", "next", "next", "next", "next", "next", "next", "next"],
      [[], [28], [14], [28], [35], [46], [53], [66], [80], [87], [88]]]),
    ([null, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 1, 13, 14, 15], [
        ["StockSpanner", "next", "next", "next", "next", "next", "next", "next", "next", "next", "next", "next", "next",
         "next", "next", "next"],
        [[], [3], [5], [8], [8], [14], [56], [25], [30], [32], [42], [43], [15], [75], [76], [81]]]),
    ([null, 1, 2, 3, 4, 1, 2, 3, 8, 1, 1, 1, 4, 1, 6, 1],
     (["StockSpanner", "next", "next", "next", "next", "next", "next", "next", "next", "next", "next", "next", "next",
      "next", "next", "next"],
     [[], [5], [11], [29], [59], [26], [26], [29], [99], [77], [40], [13], [77], [53], [89], [24]])),
)

# unit tests
for pair in test_cases:
    spanner = StockSpanner()

    print(pair)
    expected, (actions, prices) = pair

    for i, price_ in enumerate(prices):
        if not price_:
            continue

        result = spanner.next(price_[0])

        message = "OK" if result == expected[i] else "ERROR"

        print(f'{message:6}: expected: {expected[i]:4}, result: {result:4}, input: {price_[0]:4}')
