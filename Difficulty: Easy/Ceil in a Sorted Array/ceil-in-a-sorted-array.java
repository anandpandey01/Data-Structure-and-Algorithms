// User function Template for Java
class Solution {
    public int findCeil(int[] arr, int target) {
        // code here
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=target){
                ans = mid;
                high = mid-1;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
        }
        return ans;
    }
}
