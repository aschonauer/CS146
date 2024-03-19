
# Converts Adjacency List to an Adjacency Matrix
# input: adj_list = adjacency list
# output: m = adjacency matrix
def listToMatrix(self, adj_list):
    m = []
    i = 0
    for row_num in adj_list:                # For each key in the list
        m.append([])                            # Make a new row in matrix
        for column_num in adj_list:             # For each key in the list
            if column_num in adj_list[row_num]:     # if the key for column is in the list
                m[i].append(1)                      # append True, otherwise False (1 and 0)
            else:
                m[i].append(0)
        i += 1
    return m


# Converts Adjacency Matrix to an Adjacency List
# input: m = adjacency matrix
# output: adj_list = adjacency list
def matrixToList(self, m):
    adj_list = {}
    row_num = 0
    for row in m:               # for each row of matrix
        row_num += 1
        adj_list[row_num] = []      # create a new list
        col_num = 0
        for num in row:             # for each element in the row
            col_num += 1
            if num == 1:                # if the element is true add it to the list
                adj_list[row_num].append(col_num)
    return adj_list


# Reverses Adjacency List of graph edge directions
# input: g = adjacency list with directed edges
# output: new_dict = reversed adjacency list
def reverseEdgesList(self, g):
    new_dict = {}
    for row_num in g:           # create empty lists for each key
        new_dict[row_num] = []
    for row_num in g:           # for each row key
        for col_num in g[row_num]:  # for each col value
            new_dict[col_num].append(row_num)   # let the col become the key and add the old key as a value
    return new_dict


# Reverses Adjacency Matrix of graph edge directions
# input: g = adjacency matrix with directed edges
# output: reversed_matrix = reversed adjacency matrix
def reverseEdgesMatrix(self, g):
    reversed_matrix = []
    # Create empty matrix of g's size
    for i in range(len(g)):
        reversed_matrix.append([])
        for j in range(len(g)):
            reversed_matrix[i].append("E")
    # Reverse indexes for the matrix
    for i in range(len(g)):
        for j in range(len(g)):
            reversed_matrix[j][i] = g[i][j]
    return reversed_matrix


adjacency_list = {
    1: [3],
    2: [4],
    3: [5, 6, 7],
    4: [5, 6, 7],
    5: [8],
    6: [8],
    7: [8],
    8: []
}

print("Adjacency List to Matrix: ")
matrix = listToMatrix(listToMatrix, adjacency_list)
for line in matrix:
    print(line)
print()

new_list = matrixToList(matrixToList, matrix)
print("Matrix back to Adjacency List: ")
for line in new_list:
    print(line, ": ", new_list[line])
print()

reversed_list = reverseEdgesList(reverseEdgesList, new_list)
print("The directed graph Adjacency List reversed: ")
for line in reversed_list:
    print(line, ": ", reversed_list[line])
print()

reversed_graph = reverseEdgesMatrix(reverseEdgesMatrix, matrix)
print("The directed graph Adjacency Matrix reversed: ")
for line in reversed_graph:
    print(line)
