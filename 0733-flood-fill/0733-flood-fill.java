class Solution {
    int rows;
    int cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) { 
        rows = image.length;
        cols = image[0].length;
        boolean visited[][] = new boolean[rows][cols];
        dfs(image,visited,sr,sc,color,image[sr][sc]);
        return image;

    }
    public void dfs(int[][]image, boolean visited[][], int row, int col, int newColor, int curColor){
        if(row<0 || row>=rows || col<0 || col>=cols) return;
        if(image[row][col]!= curColor) return;
        if(visited[row][col] == true) return;

        image[row][col] = newColor;
        visited[row][col] = true;
        int [][] adjList = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
        for(int neighbour[] : adjList){
            dfs(image,visited,neighbour[0],neighbour[1],newColor,curColor);
        }
    }
}