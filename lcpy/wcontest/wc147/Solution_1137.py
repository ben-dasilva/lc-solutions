from typing import List

class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0: return 0
        f1, f2, f3 = 0, 1, 1
        for i in range(3, n+1):
            f1, f2, f3 = f2, f3, f1+f2+f3
        return f3
