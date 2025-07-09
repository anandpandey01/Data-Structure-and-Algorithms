class Solution {
    int minRow(int mat[][]) {
        // code here
        int m = mat.length;   int n = mat[0].length;
        int ones = Integer.MAX_VALUE;
        int index = -1;

        for(int i=0; i<m; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            if(count<ones){
                ones = count;
                index = i;
            }
        }
        return index+1;
    }
};