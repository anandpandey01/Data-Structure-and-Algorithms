class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int n = arr.length;
        int low = 0, high = n-1;
        int first = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>target){
                high = mid-1;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
            else{
                first = mid;
                high = mid-1;
            }
        }
        low = 0; high = n-1;
        int last = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>target){
                high = mid-1;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
            else{
                last = mid;
                low = mid+1;
            }
        }
        if(first == -1 && last == -1) return 0;
        return last-first+1;
    }
}
