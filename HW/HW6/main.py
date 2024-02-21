def threeSum(self, nums: list[int]) -> list[list[int]]:
    array = []
    for i in range(len(nums) - 2):
        for j in range(i+1, len(nums) - 1):
            for k in range(j+1, len(nums)):
                if nums[i] + nums[j] + nums[k] == 0:
                    triplet = [nums[i], nums[j], nums[k]]
                    triplet.sort()
                    if triplet not in array:
                        array.append(triplet)
    return array


numStr = input("Type in array of integers separated by a ', ' to find triplets that sum to 0: \n")
numArrayStr = numStr.split(', ')
numbers = []
for num in numArrayStr:
    numbers.append(int(num))
triplets = threeSum(threeSum, numbers)
print(triplets)
