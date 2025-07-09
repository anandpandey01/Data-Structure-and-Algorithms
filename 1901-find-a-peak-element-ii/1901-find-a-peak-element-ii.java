class Solution {
    public int[] findPeakGrid(int[][] arr) {
        int m = arr.length;   int n = arr[0].length;

        int low=0, high=n-1;
        while(low<=high){
            int c = low+(high-low)/2;   // Column
            int r = findMaxRowIndex(arr,c,m);   // Sorted for Up and Down
            int left = (c-1>0)? arr[r][c-1]:-1;
            int right =(c+1<n)? arr[r][c+1]:-1;
            if(arr[r][c]> left && arr[r][c]> right){
                return new int[]{r,c};
            }
            else if(arr[r][c]< left){
                high = c-1;    
            }
            else if(arr[r][c]< right){  
                low = c+1;
            }      
        }
        return new int[]{-1,-1};
    }
    public int findMaxRowIndex(int[][]arr, int c, int r){
        int index = 0, maxElement = arr[0][c];
        for(int i=1; i<r; i++){
            if(arr[i][c]>maxElement){
                maxElement = arr[i][c];
                index = i;
            }
        }
        return index;
    }
}