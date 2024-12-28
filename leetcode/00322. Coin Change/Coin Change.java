class Solution {

    /**
    1. create a new array to store all possible value from 0 to final, each engry represent the least amount coin to get the current value(or index);
    create a value called local max
    2. for i to goal amount
        for each coins we have 
            dp(i) = dp(i-1) + 1 
            find the least coins to use to add up to current goal amount dp(i). Use dp(i-1)+coin value = dp(i). 
            arr[i-value] will give the least coin add up to i-value;
            */

    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, amount + 1);
        arr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    arr[i] = Math.min(arr[i], 1 + arr[i - coins[j]]);
                }
            }
        }
        return arr[amount] != amount + 1 ? arr[amount] : -1;
    }
}
