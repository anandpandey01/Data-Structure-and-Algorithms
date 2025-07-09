class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int m = mat.length;  int n = mat[0].length;
        // Pick one corner Either rightmost top or leftmost bottom
        int r = 0, c = n-1;
        while(r<m && c>=0){
            if(mat[r][c] > x){
                c--;
            }
            else if(mat[r][c] < x){
                r++;
            }
            else{
                return true;
            }
        }
        return false;
        
    }
}