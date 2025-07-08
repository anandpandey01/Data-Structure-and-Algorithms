class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int max = arr[0];
        for(int i=1; i<n; i++){
            max = Math.max(max,arr[i]);
        }
        int low=1, high= max;
        int ans = -1;
        while(low<=high){
            int minDivisor = low+(high-low)/2;
            if(isPossible(arr,k,n,minDivisor)){
                ans = minDivisor;
                high = minDivisor-1;
            }
            else{
                low = minDivisor+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] arr, int k, int n, int minDivisor){
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=(int)Math.ceil((double)arr[i]/minDivisor); 
        }
        return (sum<=k);
    }
}