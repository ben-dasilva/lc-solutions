from typing import List


class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        s = 0

        while len(arr) > 1:
            print(f'BEFORE: {arr}')
            prod, smallest = sorted((arr[i]*arr[i+1], i) for i in range(len(arr)-1))[0]
            arr[smallest:smallest+2]=[max(arr[smallest:smallest+2])]
            s += prod
            print(f'AFTER: {arr} (prod: {prod}, s: {s})')
        print('-'*80)
        return s
