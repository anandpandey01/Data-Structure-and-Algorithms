class Solution {
    public int splitArray(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0], sum= arr[0];
        for(int i=1; i<n; i++){
            max = Math.max(max,arr[i]);
            sum+=arr[i];
        }
        int low = max, high = sum;
        int ans = -1;
        while(low<=high){
            int minSumPossible = low+(high-low)/2;
            if(isPossible(arr,k,minSumPossible)){
                ans = minSumPossible;
                high = minSumPossible-1;
            }
            else{
                low = minSumPossible+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] arr, int k,int minSumPossible){
        int m = arr.length;
        int minSum = 0; int count=1;
        for(int i=0; i<m; i++){
            if(arr[i]> minSumPossible) return false;
            minSum+=arr[i];
            if(minSum > minSumPossible){
                count++;
                minSum = arr[i];
            }
        }
        return k >= count;
    }
}