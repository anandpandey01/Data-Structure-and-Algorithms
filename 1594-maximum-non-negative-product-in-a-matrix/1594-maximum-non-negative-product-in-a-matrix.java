class Solution {
    int rows,cols;
    class Pair{
        long max, min;
        Pair(long max,long min){
            this.max= max;
            this.min = min;
        }
    }
    public int maxProductPath(int[][] grid) {
        long MOD = (long)1e9+7;
        rows = grid.length; cols= grid[0].length;
        Pair[][]dp = new Pair[rows+1][cols+1];   // By default null
        Pair result = solve(grid,dp,0,0);
        return (result.max<0)?-1:(int)(result.max % MOD) ; 
    }
    public Pair solve(int[][] grid, Pair[][]dp,int i, int j){
        if(i==rows-1 && j== cols-1) return new Pair((long)grid[i][j],(long)grid[i][j]);
        if(dp[i][j]!= null) return dp[i][j];
        
        long maxValue = Long.MIN_VALUE, minValue = Long.MAX_VALUE;

        if(j+1<cols){
            Pair right = solve(grid,dp,i,j+1);          // Right
            long a = grid[i][j] * right.max;
            long b = grid[i][j] * right.min;
            maxValue = Math.max(maxValue,Math.max(a, b));  
            minValue = Math.min(minValue,Math.min(a, b)); 
        }         
        if(i+1<rows){
            Pair down = solve(grid, dp, i+1, j);      // Down
            long a = grid[i][j] * down.max;
            long b = grid[i][j] * down.min;
            maxValue = Math.max(maxValue,Math.max(a, b));  
            minValue = Math.min(minValue,Math.min(a, b)); 
        }
        dp[i][j] = new Pair(maxValue,minValue);     
        return dp[i][j];

    }
}