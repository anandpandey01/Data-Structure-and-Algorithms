class Solution {
    public int minPathSum(int[][] grid) {
        int row= grid.length; int col = grid[0].length;
        int[][]dp = new int[row+1][col+1];
        for(int i=0; i<=row; i++) Arrays.fill(dp[i],-1);
        return solve(grid,dp,row,col,0,0);
    }
    public int solve(int[][]grid,int[][]dp,int row, int col,int i, int j){
        if(i== row-1 && j== col-1) return  dp[i][j]= grid[i][j];
        if(dp[i][j]!= -1) return dp[i][j];
        if (i == row-1){
            dp[i][j]=  grid[i][j] + solve(grid,dp,row,col,i,j+1);
        }
        else if(j == col-1){
            dp[i][j]=  grid[i][j] + solve(grid,dp,row,col,i+1,j);
        }
        else{
            int right = grid[i][j] + solve(grid,dp,row,col,i,j+1);
            int down =  grid[i][j] + solve(grid,dp,row,col,i+1,j);
            dp[i][j] = Math.min(right,down);
        } 
        return dp[i][j];
    }
}