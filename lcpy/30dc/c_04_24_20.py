class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.d = {}
        self.head = None
        self.tail = None
        self.count = 0

    # element: [v, prev, next]

    def __promote__(self, v):
        # move out of the tail, if needed
        if self.tail == v and self.head != v:
            self.tail = v[1]
            self.tail[2] = None

        # move to the head, if not already there
        if self.head != v:
            if v[1]:
                v[1][2] = v[2]
            if v[2]:
                v[2][1] = v[1]
            self.head, v[1], v[2] = v, None, self.head
            v[2][1] = v

    def get(self, key: int) -> int:
        if key not in self.d:
            return -1

        v = self.d.get(key)

        self.__promote__(v)

        return v[3]

    def put(self, key: int, value: int) -> None:
        if key not in self.d:
            if self.count == self.capacity:
                # evict!
                del self.d[self.tail[0]]
                self.count -= 1
                if self.count:
                    self.tail = self.tail[1]
                    self.tail[2] = None

            v = [key, None, self.head, value]
            if self.head is not None:
                self.head[1] = v
            self.head = v

            if self.tail is None:
                self.tail = v

            self.d[key] = v
            self.count += 1
        else:
            v = self.d[key]
            v[3] = value

        self.__promote__(v)

    def __str__(self):
        str = f'{len(self.d)} h --> '
        p = self.head
        c = 0
        while p is not None:
            c += 1
            if c > 10:
                break
            str += f'{p[0]} '
            p = p[2]

        return str


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

# unit tests
lru = LRUCache(2)

results = [
    lru.put(1, 1),
    lru.put(2, 2),
    lru.get(1),
    lru.put(3, 3), # should evict 2
    lru.get(2),
    lru.put(4, 4),
    lru.get(1),
    lru.get(3),
    lru.get(4)
]

print(results)

lru = LRUCache(1)

results = [
    lru.put(2, 1),
    lru.get(1),
]

print(results)


lru = LRUCache(1)

results = [
    lru.put(2, 1),
    lru.get(2),
    lru.put(3, 2),
    lru.get(2),
    lru.get(3),
]

print(results)


lru = LRUCache(2)

results = [
    lru.put(2, 1),
    lru.put(2, 2),
    lru.get(2),
    lru.put(1, 1),
    lru.put(4, 1),
    lru.get(2),
]

print(results)

lru = LRUCache(3)

results = [
    lru.put(1, 1),
    lru.put(2, 2),
    lru.put(3, 3),
    lru.put(4, 4),
    lru.get(4),
    lru.get(3),
    lru.get(2),
    lru.get(1),
    lru.put(5, 5),
    lru.get(1),
    lru.get(2),
    lru.get(3),
    lru.get(4),
    lru.get(5),
]

print(results)
print('[None, None, None, None, 4, 3, 2, -1, None, -1, 2, 3, -1, 5]')