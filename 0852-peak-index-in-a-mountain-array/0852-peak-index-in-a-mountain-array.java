class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low=0, high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=arr[mid+1]){
                ans = mid;
                high = mid-1;
            }
            else if(arr[mid]<arr[mid+1]){
                low = mid+1;
            }
        }
        return ans;
    }
}