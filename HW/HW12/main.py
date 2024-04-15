import sys
from typing import List

def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
    # Minimum spanning tree be mindful of wells
    cost = 0
    current_visited = []
    visited = []
    adj_list = {}
    length = n
    for i in range(length):
        adj_list[i] = []

    # house: house connection, cost
    for pipe in pipes:
        adj_list[pipe[0] - 1].append([pipe[1] - 1, pipe[2]])
        adj_list[pipe[1] - 1].append([pipe[0] - 1, pipe[2]])

    min_well = wells[0]
    current = 0
    for i in range(len(wells)):
        well_cost = wells[i]
        if well_cost < min_well:
            min_well = well_cost
            current = i
    current_visited.append(current)
    visited.append(current)
    cost += min_well

    # Prim's algorithm on every disjoint set, except wells can also be a weight to be considered
    while len(visited) < length:
        min_cost = sys.maxsize
        for house in current_visited:
            for line in adj_list[house]:
                well_cost = wells[line[0]]
                line_cost = line[1]
                if well_cost < line_cost:
                    min_weight = well_cost
                else:
                    min_weight = line_cost
                if line[0] not in current_visited:
                    min_cost = min_weight
                    current = line[0]
        if current not in current_visited:
            current_visited.append(current)
            visited.append(current)
            cost += min_cost
        else:
            new_list = []
            for i in range(length):
                if i not in visited:
                    new_list.append(i)
            current_visited = []
            min_well = sys.maxsize
            for house in new_list:
                well_cost = wells[house]
                if min_well > well_cost:
                    min_well = well_cost
                    current = house
            current_visited.append(current)
            visited.append(current)
            cost += min_well
    return cost


houses = 4
wells = [1, 5, 8, 2]
# house num 1, house num 2, cost to lay pipe
pipes = [[1, 2, 3], [3, 4, 5]]
print("Minimum Cost:", minCostToSupplyWater(minCostToSupplyWater, houses, wells, pipes))
