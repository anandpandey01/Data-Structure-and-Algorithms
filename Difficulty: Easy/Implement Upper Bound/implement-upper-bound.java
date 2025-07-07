class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int low = 0, high = n;  // Imp not n-1
        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid]>target){
                high = mid;
            }
            else if(arr[mid]<=target){
                low = mid+1;
            }
            
        }
        return low;
    }
}
