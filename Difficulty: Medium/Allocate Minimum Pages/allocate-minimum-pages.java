
//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (k > n) return -1;   //Note
        int min = arr[0], sum = arr[0];
        for(int i=1; i<n; i++){
            min = Math.max(min,arr[i]);
            sum+=arr[i];
        }
        int low = min, high = sum;
        int ans = -1;
        while(low<=high){
            int minPagesPossible = low+(high-low)/2;
            if(isPossible(arr,k,minPagesPossible)){
                ans = minPagesPossible;
                high = minPagesPossible-1;
            }
            else{
                low = minPagesPossible+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] arr, int k, int minPagesPossible){
        int m = arr.length;
        int totalPages = 0,students=1;
        for(int i=0; i<m; i++){
            if (arr[i] > minPagesPossible) return false;  //Note
            totalPages += arr[i];
            if(totalPages>minPagesPossible){
                students++;
                totalPages = arr[i];
            }
        }
        return students <= k;
    }
}