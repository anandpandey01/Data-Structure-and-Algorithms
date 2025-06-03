class Solution {
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count=0;
        for(int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][]grid, int row, int col){
        if(row<0 || row>=rows || col<0 || col>=cols) return;
        if(grid[row][col]!='1') return;

        grid[row][col] = '#';
       int [][]adjList = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};
       for(int[]neighbour : adjList){
            int r = neighbour[0];
            int c = neighbour[1];
            dfs(grid,r,c);
       } 
    }
}