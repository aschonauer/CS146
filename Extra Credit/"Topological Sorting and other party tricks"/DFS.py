

def reverseEdgesList(self, g):
    new_dict = {}
    for row_num in g:           # create empty lists for each key
        new_dict[row_num] = []
    for row_num in g:           # for each row key
        for col_num in g[row_num]:  # for each col value
            new_dict[col_num].append(row_num)   # let the col become the key and add the old key as a value
    return new_dict


def outDegrees(adj_list):
    outDegrees = {}
    for key in adj_list:
        outDegrees[key] = 0
    for key in adj_list:
        for value in adj_list[key]:
            outDegrees[key] += 1
    return outDegrees


def DFSSort(adj_list):
    stack = []
    visited = []
    out_degrees = outDegrees(adj_list)
    reverse_edges = reverseEdgesList(reverseEdgesList, adj_list)
    for key in adj_list:
        if out_degrees[key] == 0:
            stack.append(key)

    while stack:
        node_key = stack.pop()
        visited.append(node_key)
        for out_edge in reverse_edges[node_key]:
            out_degrees[out_edge] -= 1
            if out_degrees[out_edge] == 0:
                stack.append(out_edge)

    if len(visited) != len(adj_list):
        return []

    visited.reverse()
    return visited


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

dfs_sorted = DFSSort(adj_list)
print(dfs_sorted)
