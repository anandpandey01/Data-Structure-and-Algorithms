class Solution {
    int n;
    boolean[]dp;
    public boolean canJump(int[] nums) {
        n = nums.length;
        dp = new boolean[n];
        dp[0] = true;               // Possible to reach index 0
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(dp[j] == true && nums[j]+j>=i){
                    dp[i] = true; break;
                } 
            }
        }
        return dp[n-1];
    }
}