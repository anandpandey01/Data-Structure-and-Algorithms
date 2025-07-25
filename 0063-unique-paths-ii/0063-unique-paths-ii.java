class Solution {
    // Instead of Previous Logic you can simply think as soon as you encounter 1
    // in 1st row or col leave them as they are by default 0
    // Much easier than previous Approach
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {      
        int m = obstacleGrid.length;  int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        
        for(int i=1; i<m;i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }       
            }
        }
        return dp[m-1][n-1];
        
    }
    
}