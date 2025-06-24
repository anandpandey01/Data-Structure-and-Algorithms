class Solution {   // Converting into Unbounded Knapsack
    int n;
    int[][]dp;
    public int cutRod(int[] price) {
        // code here
        n = price.length;
        dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i],-1);
        int[] wt = new int[n];
        for(int i=0; i<n; i++) wt[i] = i+1;
        return solve(wt,price,n,0);
    }
    public int solve(int[]wt, int[] price,int W,int i){
        if(i== n || W== 0) return 0;
        if(dp[i][W]!= -1) return dp[i][W];
        int take = 0;
        if(wt[i]<=W){
            take = price[i]+ solve(wt,price,W-wt[i],i);
        }
        int skip = solve(wt,price,W,i+1);
        return dp[i][W] = Math.max(take,skip);
    }
}