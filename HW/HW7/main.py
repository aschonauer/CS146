from typing import List


def minMeetingRooms(self, intervals: List[List[int]]) -> int:
    intervals.sort()
    if len(intervals) == 0:
        return 0
    servers = 1
    for j in range(1, len(intervals)):
        interval = intervals[j]
        prev_int = intervals[j - 1]
        if prev_int[0] <= interval[0] < prev_int[1]:
            servers += 1
    return servers


length = int(input("Enter number of intervals: "))
intervals = []
for i in range(length):
    nums = input("Input pair ex. 0,1: ")
    numbs = nums.split(",")
    pair = [int(numbs[0]), int(numbs[1])]
    intervals.append(pair)

server = minMeetingRooms(minMeetingRooms, intervals)
print(server)
