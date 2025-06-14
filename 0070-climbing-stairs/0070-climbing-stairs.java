class Solution {                         // Recursion+Memoization
    public int climbStairs(int n) {
       int[] dp = new int[46];    //  int[] dp = new int[n+1];
       Arrays.fill(dp,-1);
       return solve(n,dp);
    }
    public int solve(int n, int[]dp){
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!= -1) return dp[n];
        int one_step = solve(n-1,dp);
        int two_step = solve(n-2,dp);
        dp[n]= one_step+two_step;
        return dp[n];
    }
}
// dp[n] stores no of distinct ways to go to n stairs