// User function Template for Java

class Solution {
    int rows;
    int cols;
    int countDistinctIslands(int[][] grid) {
       rows = grid.length;
        cols = grid[0].length;
        Set<String> uniqueIslands = new HashSet<>();
        
        for(int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]== 1){
                    StringBuilder shape = new StringBuilder();
                    dfs(grid,i,j,i,j,shape);
                    uniqueIslands.add(shape.toString());
                }
            }
        }
        return uniqueIslands.size();
    }

    public void dfs(int[][]grid, int baseRow, int baseCol, int row, int col,StringBuilder shape){
        if(row<0 || row>=rows || col<0 || col>=cols) return;
        if(grid[row][col]!= 1) return;

        grid[row][col] = 0;
        shape.append((row - baseRow) + "_" + (col - baseCol) + ",");
        
       int [][]adjList = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};
       for(int[]neighbour : adjList){
            int r = neighbour[0];
            int c = neighbour[1];
            dfs(grid,baseRow,baseCol,r,c,shape);
       } 
    }
}
