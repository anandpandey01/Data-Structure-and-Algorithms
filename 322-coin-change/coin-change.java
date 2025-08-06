class Solution {
    int n;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        dp = new int[n][amount+1];
        // for (int i = 0; i <= n; i++)  dp[i][0] = 0;
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) dp[0][j] = j / coins[0];
            else dp[0][j] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= amount; j++){
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j){
                    take = dp[i][j - coins[i]];
                    if(take != Integer.MAX_VALUE){
                        take = 1+take;
                    }
                }
                int skip = dp[i-1][j];
                dp[i][j] = Math.min(take, skip);
            }    
        }        
        return dp[n-1][amount] >= Integer.MAX_VALUE ? -1 : dp[n-1][amount];
    }

}