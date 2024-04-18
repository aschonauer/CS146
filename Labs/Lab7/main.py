from typing import List
import sys


def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
    dist = []
    for i in range(n):
        dist.append([])
        for j in range(n):
            dist[i].append(sys.maxsize)
    for edge in edges:
        dist[edge[0]][edge[1]] = edge[2]
        dist[edge[1]][edge[0]] = edge[2]

    for i in range(n):
        dist[i][i] = 0
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    neighbors = [0] * n
    for i in range(n):
        for j in range(n):
            if dist[i][j] <= distanceThreshold:
                neighbors[i] += 1
    minimum = sys.maxsize
    min_node = None
    for i in range(len(neighbors)):
        if neighbors[i] <= minimum:
            minimum = neighbors[i]
            min_node = i
    return min_node


nodes = 9
edges = [[0,6,7036],[2,3,6792],[6,8,5813],[0,2,5816],[5,7,8383],[1,8,2429],[0,4,2932],[3,7,3703],[5,8,3760],[4,5,973],[3,6,5989],[0,1,1098],[3,4,7315],[5,6,5274],[2,8,3566],[3,8,3590],[4,7,4223],[1,3,2540],[4,8,8536],[1,2,6250],[1,7,1757],[2,6,7826],[3,5,31],[1,5,7736],[2,4,5115],[0,3,4301],[0,7,4771],[4,6,3417],[0,8,2176]]
max_dist = 6235
print(findTheCity(findTheCity, nodes, edges, max_dist))


