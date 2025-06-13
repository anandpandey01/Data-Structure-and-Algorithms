class Solution {                    // Recursion+ Memoization
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp = new int[n+1];
        return solve(nums,0,n,dp);
    }
    public int solve(int[] nums,int i, int n,int[] dp){
        if(i >= nums.length) return 0;
        int skip = solve(nums,i+1,n,dp);
        int steal = nums[i]+solve(nums,i+2,n,dp);
        dp[i]= Math.max(skip,steal);
        return dp[i];
    }
}