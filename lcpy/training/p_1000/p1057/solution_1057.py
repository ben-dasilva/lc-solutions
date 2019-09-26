class Solution(object):
    def assignBikes(self, workers, bikes):
        """
        :type workers: List[List[int]]
        :type bikes: List[List[int]]
        :rtype: List[int]
        """

        def dist(a, b):
            return abs(a[0] - b[0]) + abs(a[1] - b[1])

        b_distance = [(dist(w, b), i, j) for i, w in enumerate(workers) for j, b in enumerate(bikes)]

        s_b_distance = sorted(b_distance, key=lambda e: e[0])

        b_matched = set()

        result = [None] * len(workers)

        for (d, w, b) in s_b_distance:
            if result[w] is None and b not in b_matched:
                result[w] = b
                b_matched.add(b)

        return result

s = Solution()

print(s.assignBikes([[0, 0], [1, 1], [2, 0]], [[1, 0], [2, 2], [2, 1]]))
print(s.assignBikes([[0, 0], [2, 1]], [[1, 2], [3, 3]]))
print(s.assignBikes([[0, 0], [1, 0], [2, 0], [3, 0], [4, 0], [5, 0], [6, 0], [7, 0]],
                    [[0, 999], [1, 999], [2, 999], [3, 999], [4, 999], [5, 999], [6, 999], [7, 999]]))
