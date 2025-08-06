class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0; // No of coind for Sum 0

        for (int j = 1; j <= amount; j++) {
            dp[j] = Integer.MAX_VALUE; 
            for (int coin : coins) {
                if (coin <= j  && dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}