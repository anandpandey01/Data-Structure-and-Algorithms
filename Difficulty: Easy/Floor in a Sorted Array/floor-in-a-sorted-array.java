class Solution {

    static int findFloor(int[] arr, int target) {
        // write code here
        int n = arr.length;
        int ans = -1;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>target){
                high = mid-1;
            }
            else if(arr[mid]<=target){
                ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }
}
