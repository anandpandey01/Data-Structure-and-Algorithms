class Solution {     // Bottom Up
    public int rob(int[] nums) {
        int n= nums.length;
        int[]dp = new int[n+1];
        if(n==1) return nums[0];
        dp[0]=0; dp[1]=nums[0];
        for(int i=1; i<=n-1; i++){
            int skip = dp[i-1];
            int steal = nums[i-1]+((i-2)>=0 ?dp[i-2]:0);
            dp[i] = Math.max(skip,steal);
        }  
        int result1 = dp[n-1];
        Arrays.fill(dp, 0);         // Clear
        dp[0]=0; dp[1]=0;           // Because we skipped it
        for(int i=2; i<=n; i++){
            int skip = dp[i-1];
            int steal = nums[i-1]+((i-2)>=0 ?dp[i-2]:0);
            dp[i] = Math.max(skip,steal);
        }
        int result2 = dp[n];
        return Math.max(result1, result2);
    }
}