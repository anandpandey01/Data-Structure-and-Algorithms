class Solution {
    static int rows;
    static int cols;
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        rows = mat.length;
        cols = mat[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j] == word.charAt(0) && backtrack(mat,word,i,j,0)== true){
                    return true;
                }
            }
        }
        return false;
    }
    static public boolean backtrack(char[][] mat,String word, int i, int j,int index){
        if(index == word.length()) return true; 
        if(i<0 || i>=rows || j<0 || j>=cols) return false;
        if(mat[i][j] == '$') return false;
        if(mat[i][j] != word.charAt(index)) return false;
        
        Character temp  = mat[i][j];
        mat[i][j] = '$';
        for(int[] dir: directions){
            int nr = i+dir[0];  int nc = j+dir[1];
            if(backtrack(mat,word,nr,nc,index+1) == true) return true;
        }
        mat[i][j] = temp;
        return false;
        
    }
}