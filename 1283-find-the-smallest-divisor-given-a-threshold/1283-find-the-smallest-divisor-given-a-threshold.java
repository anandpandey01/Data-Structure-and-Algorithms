class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
        int n = arr.length;
        int max = 0;
       for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
        }
        int low=1, high= max;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            long possibleThreshold =  divisor(arr,mid);
            if(possibleThreshold<=threshold){
                ans = mid;
                high = mid-1;   
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public long divisor(int[]arr,int possibleThreshold){
        int m = arr.length;
        long sum = 0;
        for(int i=0; i<m; i++){
            sum+=(long)Math.ceil((double)arr[i]/possibleThreshold);
        }
        return sum;
    }
}