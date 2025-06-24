class Solution {
    int n;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;  dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++)  dp[i][0] = 0;
        for (int j = 1; j <= amount; j++)  dp[0][j] = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int include = Integer.MAX_VALUE;
                if (coins[i - 1] <= j) {
                    int res = + dp[i][j - coins[i - 1]];
                    if (res != Integer.MAX_VALUE) {
                        include = 1 + res;
                    }
                }
                int exclude = dp[i - 1][j];
                dp[i][j] = Math.min(include, exclude);
            }
        }
        return dp[n][amount] >= Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}