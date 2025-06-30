class Solution {
    int row;
    int col;
    int totalCount; 
    int result;
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public int uniquePathsIII(int[][] grid) {
        row = grid.length; col = grid[0].length; 
        totalCount=0; result=0;
        int startX = 0, startY = 0;                
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 0){
                    totalCount++;  
                }
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                    totalCount++;  // For 1 Starting Point that is also a nonobstacle
                }
            }
        }
        dfs(grid, startX, startY, 0);  //start with count 1 for the start cell
        return result;
    }
    public void dfs(int[][] grid, int i, int j,int nonobstacleCount){
        if(i<0 || i>=row || j<0 || j>=col) return ;
        if(grid[i][j] == -1) return ;
        if(grid[i][j] == 2) {
            if (nonobstacleCount == totalCount) result++;
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = -1;
        for(int[]dir: directions){
            int nr = dir[0]+i;   int nc = dir[1]+j;
            dfs(grid,nr,nc,nonobstacleCount+1);
        }
        grid[i][j] = temp;    //BackTrack
    }

}