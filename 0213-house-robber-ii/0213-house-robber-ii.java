class Solution {                    // Memoization
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int take_0th_house = solve(nums,dp,0,n-2);
        Arrays.fill(dp,-1);
        int take_1th_house = solve(nums,dp,1,n-1);
        return Math.max(take_0th_house,take_1th_house);

    }
    public int solve(int[] nums, int[]dp,int i,int n){
        if(i>n) return 0;
        if(dp[i]!= -1) return dp[i];
        int steal = nums[i]+solve(nums,dp,i+2,n);
        int skip = solve(nums,dp,i+1,n);
        dp[i] = Math.max(steal,skip);
        return dp[i];
    }
}