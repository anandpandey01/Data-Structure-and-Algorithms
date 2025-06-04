class Solution {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows= board.length;
        cols = board[0].length;
        for(int i=0; i<rows;i++){
            if(board[i][0]=='O')       dfs(board,i,0);
            if(board[i][cols-1]=='O')  dfs(board,i,cols-1);
        }
        for(int j=0; j<cols;j++){
            if(board[0][j]=='O')        dfs(board,0,j);
            if(board[rows-1][j]=='O')   dfs(board,rows-1,j);
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O')  board[i][j] = 'X';
                else if(board[i][j]== '#') board[i][j] = 'O';
            }
        }
    }
    public void dfs(char[][] board, int row, int col){
        int [][]adjList = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};
        if(row<0 || row>=rows || col<0 || col>=cols) return;
        if(board[row][col]!='O') return;

        board[row][col]='#';
        for(int[] neighbour : adjList){
            dfs(board,neighbour[0],neighbour[1]);
        }
    }
}