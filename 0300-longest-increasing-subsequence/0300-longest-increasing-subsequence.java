class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[][]dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i],-1);
        return solve(nums,dp,n,0,-1);
    }
    public int solve(int[]nums, int[][]dp,int n,int i,int prevIndex){
        if(i>=n) return 0;
        if(dp[prevIndex+1][i]!= -1) return dp[prevIndex+1][i];

        int take=0;
        if(prevIndex == -1 || nums[i]>nums[prevIndex]){
            take = 1+solve(nums,dp,n,i+1,i);
        }
        int skip = solve(nums,dp,n,i+1,prevIndex);    // Note
        dp[prevIndex+1][i] = Math.max(take,skip);

        return dp[prevIndex+1][i];
    }
}