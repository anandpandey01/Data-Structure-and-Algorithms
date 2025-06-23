class Solution {
    int n;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        dp = new int[n][amount+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        int ans = solve(coins, amount, 0);
        return (ans == Integer.MAX_VALUE)?-1 : ans;
    }
    public int solve(int[] coins, int amount, int i){
        if(amount == 0) return 0;
        if(i == n) return Integer.MAX_VALUE;
        if(dp[i][amount]!= -1) return dp[i][amount];
        int take = Integer.MAX_VALUE;
        if(coins[i]<=amount){
            int res = solve(coins, amount - coins[i], i);   // Can take a coin any number of times
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            } 
        }
        int skip = solve(coins,amount,i+1);
        return dp[i][amount] = Math.min(take, skip);

    }
}