class Solution {
    public int uniquePaths(int m, int n) {
        int[][]dp = new int[m+1][n+1];
        for(int i=0; i<=m;i++) Arrays.fill(dp[i],-1);
        return solve(dp,m,n,0,0);
    }
    public int solve(int[][] dp, int m, int n,int i, int j){
        if(i== m-1 && j== n-1) return 1;
        if(dp[i][j]!= -1) return dp[i][j];
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        int right = solve(dp,m,n,i,j+1);
        int down = solve(dp,m,n,i+1,j);
        dp[i][j]= right+down;
        return dp[i][j];
    }
}