class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.vals = []
        self.mins = []

    def __str__(self):
        return f'[{self.vals}, {self.mins}]'

    def push(self, x: int) -> None:
        self.vals.append(x)

        if not self.mins or x <= self.mins[-1]:
            self.mins.append(x)

    def pop(self) -> None:
        v = self.vals.pop()
        if self.mins[-1] == v:
            self.mins.pop()

    def top(self) -> int:
        return self.vals[-1]

    def getMin(self) -> int:
        return self.mins[-1]

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(2)
obj.pop()
obj.push(4)
obj.push(5)
param_3 = obj.top()
param_4 = obj.getMin()

print(f'{param_3}, {param_4}')

# ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
# [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
# [null,null,null,null,2147483647,null,2000000000.0,null,2000000000.0,null,null,2147483647,2000000000.0,null,-2147483648,-2147483648,null,2000000000.0]
# [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]

ms = MinStack()
print(ms.push(2147483646))
print(ms.push(2147483646))
print(ms.push(2147483647))
print(ms.top())
print(ms.pop())
print(ms.getMin())
print(ms.pop())
print(ms.getMin())
print(ms.pop())
print(ms.push(2147483647))
print(ms.top())
print(ms.getMin())
print(ms.push(-2147483648))
print(ms.top())
print(ms.getMin())
print(ms.pop())
print(ms.getMin())

ms = MinStack()
ms.push(-2)
ms.push(0)
ms.push(-3)
print(ms.getMin())
print(ms.pop())
print(ms.top())
print(ms.getMin())