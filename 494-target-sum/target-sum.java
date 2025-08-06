class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) sum += nums[i];
        int s1 = (sum + target)/2;   // s1 - s2 = target , s1 + s2 = sum    // Subsets Sum equals k
        if ((sum + target) % 2 != 0 || (sum + target < 0)) return 0;   // Note Imp

        int [][] dp = new int [n][s1+1]; 
        for(int i=0; i<n; i++) dp[i][0] = 1;
        if(nums[0] == 0){
            dp[0][0] = 2;    // Empty and with 0
        }
        else if(nums[0] <= s1){
            dp[0][nums[0]] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<=s1; j++){
                int include = 0;
                if(nums[i] <= j){
                    include = dp[i-1][j - nums[i]];
                }
                int exclude = dp[i-1][j];
                dp[i][j] = include + exclude;
            }
        }
        return dp[n-1][s1];
    }
    // public int solve(int[] nums, int sum, int i){
    //     if(i == n && sum == 0) return 1;
    //     if(i == n) return 0;
    //     if(dp[i][sum] != null) return dp[i][sum];
    //     int take = 0;
    //     if(nums[i] <= sum){
    //         take = solve(nums, sum - nums[i], i+1);
    //     } 
    //     int skip = solve(nums, sum , i+1);
    //     return dp[i][sum] =  take + skip;

    // }
}