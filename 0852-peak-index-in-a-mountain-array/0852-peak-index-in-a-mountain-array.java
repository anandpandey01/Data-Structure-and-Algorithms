class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length; int ans = -1;
        for(int i=0; i<n-1; i++){
            if(arr[i+1]<arr[i]){
                ans = i; break;
            }
        }
        return ans;
    }
}