class Solution {
    int rows;
    int cols;
    int[][] directions  = {{1,0},{-1,0},{0,1},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        rows = grid.length;  cols = grid[0].length;
        int maxGold = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] != 0){
                   maxGold = Math.max(maxGold,dfs(grid,i,j)); 
                }
            }
        }
        return maxGold;
    }
    public int dfs(int[][] grid, int i, int j){
        if(i<0 || i>=rows || j<0 || j>=cols) return 0;
        if(grid[i][j] == 0) return 0;

        int temp = grid[i][j];
        grid[i][j] = 0;
        int gold = 0;

        for(int[] dir : directions){
            int nr = dir[0]+i;   int nc = dir[1]+j;
            gold = Math.max(gold,dfs(grid,nr,nc));   
        }
        grid[i][j] = temp;
        return temp+gold;


    }
}