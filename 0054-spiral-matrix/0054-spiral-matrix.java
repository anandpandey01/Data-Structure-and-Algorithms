class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int dir = 0; // 0 - left to right, 1 - top to bottom, 2 - right to left, 3 - bottom to up 
        int top = 0, bottom = m-1, left = 0, right = n-1;
        
        while(result.size() < (m*n)){
            if(dir == 0){
                for(int i=left; i<=right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                for(int i=top; i<=bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
            }
            else if(dir == 2){
                for(int i=right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            else if(dir == 3){
                for(int i=bottom; i>=top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1)%4;
        }
        return result;
    }
}