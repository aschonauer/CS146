
def countInDegrees(adj_list):
    inDegrees = {}
    for key in adj_list:
        inDegrees[key] = 0
    for key in adj_list:
        for value in adj_list[key]:
            inDegrees[value] += 1
    return inDegrees


def BFSSort(adj_list):
    in_degrees = countInDegrees(adj_list)
    queue = []
    sorted = []
    for key in in_degrees:
        if in_degrees[key] == 0:
            queue.append(key)
    while queue:
        node_key = queue.pop(0)
        sorted.append(node_key)
        node_pointers = adj_list[node_key]
        for key in node_pointers:
            in_degrees[key] -= 1
            if in_degrees[key] == 0:
                queue.append(key)
    if len(sorted) != len(adj_list):
        return []
    return sorted


adj_list = {
    1: [3],
    2: [4, 3],
    3: [5, 6, 7],
    4: [5, 6, 7],
    5: [8],
    6: [8],
    7: [8, 6, 5],
    8: []
}

bfs_sorted = BFSSort(adj_list)
print(bfs_sorted)
