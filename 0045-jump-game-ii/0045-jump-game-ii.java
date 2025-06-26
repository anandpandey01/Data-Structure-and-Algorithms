class Solution {
    int n;
    int[]dp;
    public int jump(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,0);
    }
    public int solve(int[] nums, int i){
        if(i>=n-1) return 0;

        int minJumps=Integer.MAX_VALUE;
        if(dp[i]!= -1) return dp[i];
        for(int jump=1; jump<=nums[i]; jump++){
            int next = solve(nums, i+jump);
            if(next!= Integer.MAX_VALUE){
                minJumps = Math.min(minJumps,1+next);
            }
        }
        return dp[i] = minJumps;
    }
}