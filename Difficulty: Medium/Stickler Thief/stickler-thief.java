class Solution {
    int n;
    public int findMaxSum(int arr[]) {
        // code here
        n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(arr,dp,0);
    }
    public int solve(int arr[], int[] dp, int i){
        if(i >= n) return 0;
        if(dp[i]!= -1) return dp[i];
        int take = arr[i]+solve(arr,dp,i+2);
        int skip = solve(arr,dp,i+1);
        dp[i] = Math.max(take,skip);
        return dp[i];
        
    }
}