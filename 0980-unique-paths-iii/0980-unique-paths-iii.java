class Solution {
    int rows; int cols; int nonObstacleCount; int totalPath;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        nonObstacleCount = 0;  totalPath = 0;
        int start_x = 0; int start_y =0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    start_x = i; start_y= j;
                    nonObstacleCount++;
                }
                else if(grid[i][j] == 0){
                    nonObstacleCount++;
                }
            }
        }
        solve(grid,start_x,start_y,0);
        return totalPath;
    }
    public void solve(int[][] grid, int i, int j, int count){
        if(i<0 || i>=rows || j<0 || j>=cols) return;
        if(grid[i][j] == -1) return;
        if(grid[i][j] == 2){
            if(count == nonObstacleCount) totalPath++;
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = -1;
        for(int[] dir: directions){
            int nr = dir[0]+i;  int nc = dir[1]+j;
            solve(grid,nr,nc,count+1);
        }
        grid[i][j] = temp;
    }
}