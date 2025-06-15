// User function Template for Java

class Solution {
    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int[]dp = new int[n+1];
        dp[0]=0; dp[1] = arr[0];

        for(int i=2; i<=n; i++){
            int take = arr[i-1]+ dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(take,skip);
        }
        return dp[n];
    }
}