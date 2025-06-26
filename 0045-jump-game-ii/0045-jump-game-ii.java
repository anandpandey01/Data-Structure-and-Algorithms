class Solution {
    int n;
    int[]dp;
    public int jump(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[0] = 0;
        for(int i=1; i<n; i++){
            for(int j = i-1; j>=0; j--){
                if(dp[j] != Integer.MAX_VALUE && nums[j]+j>=i){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }    
}