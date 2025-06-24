class Solution {
    static int n;
    static int[][]dp;
    static int knapsack(int W, int val[], int wt[]) {
        n = wt.length;
        dp = new int[n+1][W+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i],-1);
        return solve(W,val,wt,0);
        
    }
    static int solve(int W, int val[], int wt[], int i){
        if(i==n) return 0;
        if(dp[i][W]!= -1) return dp[i][W];
        int take =0;
        if(wt[i]<=W){
            take = val[i]+ solve(W-wt[i],val,wt,i+1);
        }
        int skip = solve(W,val,wt,i+1);
        return dp[i][W] =  Math.max(take,skip);
    }
}
