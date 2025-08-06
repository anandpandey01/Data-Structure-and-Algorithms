class Solution {
    int n;
    Integer[][]dp;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) sum += nums[i];
        // s1 - s2 = target , s1 + s2 = sum 
        int s1 = (sum + target)/2;     // Subsets Sum equals k
        if ((sum + target) % 2 != 0 || (sum + target < 0)) return 0;   // Note Imp

        dp = new Integer[n][s1+1]; 
        return solve(nums, s1, 0);

    }
    public int solve(int[] nums, int sum, int i){
        if(i == n && sum == 0) return 1;
        if(i == n) return 0;
        if(dp[i][sum] != null) return dp[i][sum];
        int take = 0;
        if(nums[i] <= sum){
            take = solve(nums, sum - nums[i], i+1);
        } 
        int skip = solve(nums, sum , i+1);
        return dp[i][sum] =  take + skip;

    }
}