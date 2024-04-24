import java.util.Arrays;

public class Main {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin: coins) {
                if (i - coin >= 0) {
                    if (arr[i - coin] != Integer.MAX_VALUE
                            && 1 + arr[i - coin] < arr[i]) {
                        arr[i] = 1 + arr[i - coin];
                    }
                }
            }
        }

        if (arr[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return arr[amount];
    }
    public static void main(String[] args) {
        int[] coins = new int[]{186, 419, 83, 408};
        int amount = 6249;
        Main obj = new Main();
        System.out.println(obj.coinChange(coins, amount));
    }
}