class Solution {
    int n;
    int[][]dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[n][amount+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return solve(amount,coins,0);
    }
    public int solve(int amount, int[] coins, int i){
        if(amount == 0) return 1;
        if(i == n) return 0;
        if(dp[i][amount]!= -1) return dp[i][amount];
        int take = 0;
        if(coins[i]<=amount){
           take =  solve(amount - coins[i],coins,i);    // Note not i+1
        }
        int skip = solve(amount,coins,i+1); 
        return dp[i][amount] = take+skip;

    }
}