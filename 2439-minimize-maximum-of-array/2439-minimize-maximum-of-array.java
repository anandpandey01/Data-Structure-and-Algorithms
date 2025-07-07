class Solution {
    public int minimizeArrayValue(int[] arr) {
        int n = arr.length; 
        int max = arr[0];  int ans = 0;
        for(int i=1; i<n; i++){
            max = Math.max(max,arr[i]);
        }
        int low=1, high = max;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isValid(arr,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean isValid(int[] arr, int minPossible){
        int m = arr.length;
        long[] nums = new long[m];
        for (int i = 0; i < m; i++) nums[i] = arr[i];
        for(int i=0; i<m-1; i++){
            if(nums[i]> minPossible) return false;
            long buffer = minPossible - nums[i];
            nums[i+1] = nums[i+1]- buffer;
        }
        return (nums[m-1]<=minPossible);
    }
}