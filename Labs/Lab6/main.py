
def countInDegrees(array_list):
    inDegrees = {}
    for pair in array_list:
        inDegrees[pair[0]] = 0
        inDegrees[pair[1]] = 0
    for pair in array_list:
        inDegrees[pair[0]] += 1
    return inDegrees


def canFinish(numCourses, prerequisites):
    # topological sort
    queue = []
    sorted = []
    in_degrees = countInDegrees(prerequisites)
    for key in in_degrees:
        if key < 0 or key >= numCourses:
            return False
        if in_degrees[key] == 0:
            queue.append(key)
    while queue:
        node_key = queue.pop(0)
        sorted.append(node_key)
        for pair in prerequisites:
            if pair[1] == node_key:
                in_degrees[pair[0]] -= 1
                if in_degrees[pair[0]] == 0:
                    queue.append(pair[0])
    return len(sorted) == len(in_degrees)


courses = 4
prereq = [[1, 2], [2, 0], [3, 0], [3, 1]]
print(canFinish(courses, prereq))
print("Expected: True")
print()
courses = 5
prereq = [[1, 2], [2, 0], [3, 0], [3, 1], [0, 1]]
print(canFinish(courses, prereq))
print("Expected: False")
print()
courses = 4
prereq = [[1, 2], [2, 0], [0, 1]]
print(canFinish(courses, prereq))
print("Expected: False")
