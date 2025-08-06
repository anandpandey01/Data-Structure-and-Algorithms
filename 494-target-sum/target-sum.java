class Solution {
    int n;
    //Integer[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        //int maxSum = 0;    for(int i=0; i<n; i++) maxSum += nums[i];
       // dp = new Integer[n][maxSum+1];
        return solve(nums, target, 0, 0);
    }

    public int solve(int[] nums, int target, int sum, int i){
        if(i == n && target == sum) return 1;
        if(i == n ) return 0;
        //if(dp[i][sum] != null) return dp[i][sum];
        int positive = solve(nums, target, sum + nums[i], i+1);
        int negative = solve(nums, target, sum - nums[i], i+1);

        
        //return dp[i][sum] = positive + negative;
        return positive + negative;

    }
}