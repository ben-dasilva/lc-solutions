from typing import List
import collections

class FirstUnique:
    """You have a queue of integers, you need to retrieve the first unique
    integer in the queue."""

    def __init__(self, nums: List[int]):
        self.known = collections.defaultdict(int)
        self.unique = collections.deque()
        for i in nums:
            self.known[i] += 1
        for i in [x for x, v in self.known.items() if v == 1]:
            self.unique.append(i)

    def showFirstUnique(self) -> int:
        v = self.unique[0] if self.unique else -1
        print(f'v: {v}, known: {self.known}, unique: {self.unique}')
        return v

    def add(self, value: int) -> None:
        prev = self.known[value]

        if prev == 1:
            self.unique.remove(value)
        elif prev == 0:
            self.unique.append(value)

        self.known[value] += 1


# Your FirstUnique object will be instantiated and called as such:
# obj = FirstUnique(nums)
# param_1 = obj.showFirstUnique()
# obj.add(value)

firstUnique = FirstUnique([2, 3, 5])
firstUnique.showFirstUnique()  # return 2
firstUnique.add(5)  # the queue is now [2,3,5,5]
firstUnique.showFirstUnique()  # return 2
firstUnique.add(2)  # the queue is now [2,3,5,5,2]
firstUnique.showFirstUnique()  # return 3
firstUnique.add(3)  # the queue is now [2,3,5,5,2,3]
firstUnique.showFirstUnique()  # return -1

print("--------------------")

firstUnique = FirstUnique([7,7,7,7,7,7])
firstUnique.showFirstUnique() # return -1
firstUnique.add(7)            # the queue is now [7,7,7,7,7,7,7]
firstUnique.add(3)            # the queue is now [7,7,7,7,7,7,7,3]
firstUnique.add(3)            # the queue is now [7,7,7,7,7,7,7,3,3]
firstUnique.add(7)            # the queue is now [7,7,7,7,7,7,7,3,3,7]
firstUnique.add(17)           # the queue is now [7,7,7,7,7,7,7,3,3,7,17]
firstUnique.showFirstUnique() # return 17
