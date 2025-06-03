class Solution {
    int rows;
    int cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows= image.length;
        cols = image[0].length;
        dfs(image,sr,sc,image[sr][sc],color);
        return image;

    }

    public void dfs(int[][] image,int row,int col, int curColor, int newColor){
        if(row>=rows || row<0 || col>=cols || col<0) return;
        if(image[row][col] != curColor) return;
        if(image[row][col] == newColor) return;

        image[row][col] = newColor;
        int adjList[][] = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
        for(int neighbour[]  : adjList){
            dfs(image, neighbour[0],neighbour[1],curColor,newColor);
        }
    }

}