
n = input("Enter integer to find its fibonacci number: ")
n = int(n)
prev1 = 0
prev2 = 0
num = 0

if not n <= 1:
    num = 1

for i in range(n-2):
    prev2 = prev1
    prev1 = num
    num = prev1 + prev2

print(num)
