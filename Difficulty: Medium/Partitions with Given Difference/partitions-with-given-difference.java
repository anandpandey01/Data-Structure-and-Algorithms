
class Solution {
    int n;
    int[][]dp;
    int countPartitions(int[] arr, int d) {
        // code here
        n = arr.length;   int sum=0;
        for(int i=0; i<n; i++) sum+=arr[i];
        if ((sum + d) % 2 != 0 || sum < d) return 0;
        int sum1 = (sum+d)/2;
        dp = new int[n][sum1+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return solve(arr,sum1,0);
        
    }
    int solve(int[] arr, int sum, int i){
        if(sum == 0 && i == n) return 1;
        if(i == n) return 0;
        if(dp[i][sum]!= -1) return dp[i][sum];
        int include = 0;
        if(arr[i]<=sum){
            include = solve(arr,sum-arr[i],i+1);
        }
        int exclude = solve(arr,sum,i+1); 
        return dp[i][sum] = include+exclude;
        
        
    }
}
