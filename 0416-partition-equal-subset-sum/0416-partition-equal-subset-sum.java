class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int i=0; i<n; i++) sum+=nums[i];
        boolean [][] dp = new boolean[n+1][sum+1];
        if(sum %2 != 0) return false;
        for(int i=0; i<=n; i++) dp[i][0] = true;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum/2; j++){
                boolean include = false;
                if(nums[i-1]<=j){
                    include = dp[i-1][j -nums[i-1]];
                }
                boolean exclude  =  dp[i-1][j];   
                dp[i][j] =  include || exclude;     
            }     
        }
        return dp[n][sum/2];
    }
}