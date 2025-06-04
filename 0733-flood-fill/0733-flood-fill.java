class Solution {
    int rows;
    int cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        dfs(image,sr,sc,image[sr][sc],color);
        return image;
    }
    public void dfs(int[][]image,int row, int col, int curColor, int newColor){
        if(row<0 || row>=rows || col<0 || col>=cols) return;
        if(image[row][col] != curColor) return;
        if(image[row][col] == newColor) return;

        image[row][col] = newColor;
        int [][]adjList = {{row-1,col},{row+1,col},{row,col-1},{row,col+1}};
        for(int[] neighbour : adjList){
            int r = neighbour[0];
            int c = neighbour[1];
            dfs(image,r,c,curColor,newColor);
        }
    }
}