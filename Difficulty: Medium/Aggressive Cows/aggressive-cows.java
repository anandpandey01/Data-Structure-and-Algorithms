// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] arr, int k) {
        // code here
        int n = arr.length;
        int max = arr[0];
        for(int i=1; i<n; i++){
            max = Math.max(max, arr[i]);
        }
        int low=1, high = max;
        int ans = -1;
        while(low<=high){
            int maxPossibleDistance = low+(high-low)/2;
            if(isPossible(arr,k,n,maxPossibleDistance)){
                ans = maxPossibleDistance;
                low = maxPossibleDistance+1;
            }
            else{
                high = maxPossibleDistance-1;
            }
        }
        return ans;
        
    }
    public static boolean isPossible(int[] arr, int k, int n, int maxPossibleDistance){
        Arrays.sort(arr);
        int lastPosition = arr[0],cows = 1;
        for(int i=1; i<n; i++){
            if(arr[i] - lastPosition >= maxPossibleDistance){
                cows++;  
                lastPosition = arr[i];
            }
        }
        return (cows>=k);
        
    }
}