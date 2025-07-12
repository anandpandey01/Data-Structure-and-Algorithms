class Solution {
    int countWays(int n) {
        // your code here
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n,dp);
    }
    int solve(int i,int n, int[]dp){
        if(i>n) return 0;
        if(i == n) return 1;
        if(dp[i]!= -1) return dp[i];
        int oneStair = solve(i+1,n,dp);
        int twoStair = solve(i+2,n,dp);
        dp[i] = oneStair+twoStair;
        return dp[i];
    }
}
