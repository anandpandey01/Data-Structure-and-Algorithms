class Solution {
    int n;
    Boolean[]dp;
    public boolean canJump(int[] nums) {
        n = nums.length;
        dp = new Boolean[n];
        return solve(nums,0);

    }
    public boolean solve(int[] nums,int i){
        if(i>= n-1) return true;

        if(dp[i]!= null) return dp[i];
        for(int index=1;index<=nums[i]; index++){
            if (solve(nums,i+index)== true) return dp[i] = true;
        }
        return dp[i]=false;
    }
}