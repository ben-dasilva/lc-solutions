from typing import List
import collections

class Solution:
    def possibleBipartition(self, N: int, dislikes: List[List[int]]) -> bool:
        edges = collections.defaultdict(list)

        for i in dislikes:
            edges[i[0]].append(i[1])
            edges[i[1]].append(i[0])

        if not dislikes:
            return True

        unvisited = collections.deque()

        unvisited.append(-1)
        unvisited.append(sorted(list(edges.keys()))[0])

        this_set, other_set = {'black'}, {'red'}

        while unvisited:
            node = unvisited.popleft()
            #print(f"node: {node}, unvisited: {unvisited}")
            if node == -1:
                #print("flipping...")
                if unvisited:
                    unvisited.append(-1)
                    #print(f" --> unvisited: {unvisited}")
                elif edges:
                    unvisited.append(-1)
                    unvisited.append(sorted(list(edges.keys()))[0])

                this_set, other_set = other_set, this_set
                continue

            #print(f"adding {node} to this_set: {this_set}, other_set:  {other_set}...")

            if node in other_set:
                #print(f"Oops... {node} alread exists in {other_set}")
                return False
            
            this_set.add(node)

            if edges[node]:
                #print(f"    ==> connected to '{node}' --> {edges[node]}")
                for other in edges[node]:
                    other_set.add(other)
                    unvisited.append(other)
            
            del edges[node]

            if not unvisited and edges:
                unvisited.append(-1)
                unvisited.append(sorted(list(edges.keys()))[0])
        return True

test_cases = (
    (True, 4, [[1,2],[1,3],[2,4]]),
    (False, 5, [[1,2],[2,3],[3,4],[4,5],[1,5]]),
    (False, 3, [[1,2],[1,3],[2,3]]),
    (False, 5, [[1,2],[3,4],[4,5],[3,5]]),
    (True, 10, [[4,7],[4,8],[5,6],[1,6],[3,7],[2,5],[5,8],[1,2],[4,9],[6,10],[8,10],[3,6],[2,10],[9,10],[3,9],[2,3],[1,9],[4,6],[5,7],[3,8],[1,8],[1,7],[2,4]]),
    (True, 10, [[5,9],[5,10],[5,6],[5,7],[1,5],[4,5],[2,5],[5,8],[3,5]]),
)

for pair in test_cases:
    expected, n, dislikes = pair

    result = Solution().possibleBipartition(n, dislikes)

    message = "OK" if result == expected else "ERROR"

    print(f'{message:6}: expected: {expected:3}, result: {result}, input: {n, dislikes}')
