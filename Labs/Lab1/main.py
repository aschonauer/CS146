# This program takes an array and finds 2 indexes that can create the target sum

# Creates and takes in the list
nums = list(())
length = int(input("Enter length of array: "))
for i in range(length):
    nums.append(int(input("Enter element: ")))

# Takes the target sum
target = int(input("Enter target sum: "))

# Creates a dictionary and each key has a value of the target - the number in array
numsList = {}
for i in range(length):
    numsList[nums[i]] = target - nums[i]

# Search the dictionary for the pair to find the target sum
for i in range(length):
    num1 = numsList[nums[i]]
    for j in range(i+1, length):
        if num1 == nums[j]:
            print("index 1: ", i, "\nindex 2: ", j)
