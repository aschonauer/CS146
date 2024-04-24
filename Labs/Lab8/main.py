import sys
from typing import List


def coinChange(self, coins: List[int], amount: int) -> int:
    arr = [sys.maxsize] * (amount + 1)
    arr[0] = 0
    for i in range(amount + 1):
        for coin in coins:
            if i - coin >= 0:
                if 1 + arr[i - coin] < arr[i]:
                    arr[i] = 1 + arr[i-coin]
    if arr[amount] == sys.maxsize:
        return -1
    return arr[amount]


coins = [186,419,83,408]
amount = 6249
coin_amount = coinChange(coinChange, coins, amount)
print(coin_amount)
