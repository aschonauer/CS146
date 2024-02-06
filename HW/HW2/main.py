def isBadVersion(version):
    if version >= 70:
        return True
    return False


n = input("Enter number of versions: ")

low = 1
high = int(n)
verNum = 0
print(low, " ", high)

while low <= high:
    mid = int(low + (high - low) / 2)
    bad = isBadVersion(mid)
    print(mid)
    if bad:
        verNum = mid
        high = mid - 1
    if not bad:
        low = mid + 1

print('Version ', verNum, ' is the first bad version')
