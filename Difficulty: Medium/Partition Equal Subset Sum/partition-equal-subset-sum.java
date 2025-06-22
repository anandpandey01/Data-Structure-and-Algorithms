class Solution {
    static int n;
    static Boolean [][]dp;
    static boolean equalPartition(int arr[]) {
        // code here
        n = arr.length;
        int sum=0;
        for(int i=0; i<n; i++) sum+=arr[i];
        dp = new Boolean[n][sum+1];
        if(sum%2 != 0) return false;
        return solve(arr, sum/2, 0);
        
    }
    static boolean solve(int arr[], int sum, int i){
        if(sum==0) return true;
        if(i==n) return false;
        if(dp[i][sum]!= null) return dp[i][sum];
        boolean include = false;
        if(arr[i]<=sum){
            include = solve(arr, sum -arr[i],i+1);
        }
        boolean exclude  = solve(arr, sum, i+1);
        return dp[i][sum] =  include || exclude;
        
    }
}