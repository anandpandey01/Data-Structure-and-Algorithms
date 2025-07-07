// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        int max = stalls[0];
        for(int i=1; i<n; i++){
            max = Math.max(max,stalls[i]);
        }
        int ans = -1;
        int low = 1, high = max;
        while(low<=high){
            int minPossibleDistance = low+(high-low)/2;
            if(isPossible(stalls,k,minPossibleDistance)){
                ans = minPossibleDistance;
                low = minPossibleDistance+1;
            }
            else{
                high = minPossibleDistance-1;
            }
        }
        return ans;
        
    }
    public static boolean isPossible(int[] stalls, int k,int minPossibleDistance){
        int n = stalls.length;
        Arrays.sort(stalls);     // Note
        int lastPosition = stalls[0];
        int cows = 1;
        for(int i=1; i<n; i++){
            if(stalls[i] - lastPosition>=minPossibleDistance){
                cows++;
                lastPosition = stalls[i];
            }
            if(cows == k) return true;
        }
        return false;
    }
}