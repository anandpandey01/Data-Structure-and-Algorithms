class Solution {
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        int[][]dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
        return solve(arr,dp,n,0,-1);
    }
    static int solve(int[]arr, int[][]dp, int n, int i, int prevIndex){
        if(i>=n) return 0;
        if(dp[i][prevIndex+1]!= -1) return dp[i][prevIndex+1];
        int take=0;
        if(prevIndex == -1 || arr[i]>arr[prevIndex]){
            take = 1 + solve(arr,dp,n,i+1,i);
        }
        int skip = solve(arr,dp,n,i+1,prevIndex);
        dp[i][prevIndex+1] = Math.max(take,skip);
        return dp[i][prevIndex+1];
    }
}