class Solution {
    int n;
    int maxValue(int[] arr) {
        n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int take_0th = solve(arr,dp,0,n-2);
        Arrays.fill(dp,-1);
        int skip_0th = solve(arr,dp,1,n-1);
        return Math.max(take_0th,skip_0th);
    }
    public int solve(int arr[], int[] dp, int i, int n){
        if(i > n) return 0;
        if(dp[i]!= -1) return dp[i];
        int take = arr[i]+solve(arr,dp,i+2,n);
        int skip = solve(arr,dp,i+1,n);
        dp[i] = Math.max(take,skip);
        return dp[i];
        
    }
}
