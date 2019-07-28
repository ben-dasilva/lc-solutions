import collections as co
import heapq


def build_adjacents(edges):
    return []


def dijkstra(nodes, edges, start):
    pq = [(float('inf'), i) for i in range(len(nodes))]
    pq[start] = (0, start)

    heapq.heapify(pq)
    adjacent = build_adjacents(edges)

    while pq:
        node = heapq.heappop(pq)
        for adj in adjacent[node[1]]:
            v = pq.index()

    return heapq.nsmallest(1, pq)


def sieve_of_eratosthenes(n):
    primes = {i for i in range(2, n + 1)}

    for p in range(2, int(n ** .5) + 1):
        for s in range(p * 2, n + 1, p):
            primes.discard(s)

    return primes


print(dijkstra([1, 2, 3, 4], [], 1))
