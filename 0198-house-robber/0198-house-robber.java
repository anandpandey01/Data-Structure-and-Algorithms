class Solution {                    // Recursion+ Memoization
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,n,dp);
    }
    public int solve(int[] nums,int i, int n,int[] dp){
        if(i >= nums.length) return 0;
        if(dp[i]!= -1) return dp[i];
        int skip = solve(nums,i+1,n,dp);
        int steal = nums[i]+solve(nums,i+2,n,dp);
        dp[i]= Math.max(skip,steal);
        return dp[i];
    }
}
// The maximum amount of money that can be robbed from the first i + 1 houses 
// (i.e. from house 0 to house i)