class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;  int n = obstacleGrid[0].length;
        int[][]dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) Arrays.fill(dp[i], -1);
        return solve(obstacleGrid,dp,m,n,0,0);
    }
    public int solve(int[][] obstacleGrid,int[][]dp,int m,int n,int i, int j){
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        if(obstacleGrid[i][j]!= 0) return 0;
        
        if(i== m-1 && j== n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];     
        int right = solve(obstacleGrid,dp,m,n,i,j+1);
        int down = solve(obstacleGrid,dp,m,n,i+1,j);
        dp[i][j] = right+down;
        return dp[i][j];
    }
}