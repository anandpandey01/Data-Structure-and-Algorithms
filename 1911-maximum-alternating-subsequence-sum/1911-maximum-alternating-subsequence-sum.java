class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n= nums.length;
        long[][]dp = new long[n+1][2];
        for(int i=0; i<n+1;i++) Arrays.fill(dp[i],-1);
        return solve(nums,dp,n,0,true);   // 0 even index -- true
    }
    public long solve(int[] nums, long[][]dp, long n,int index,boolean flag){
        if(index>=n) return 0;
        int f = flag ? 1 : 0;
        if(dp[index][f]!= -1) return dp[index][f];
        long skip = solve(nums,dp,n,index+1,flag);
        long value = nums[index];
        if(flag== false) value = -value;
        long take = solve(nums,dp,n,index+1,!flag)+value;
        dp[index][f]=  Math.max(skip,take);
        return dp[index][f];
    }
}