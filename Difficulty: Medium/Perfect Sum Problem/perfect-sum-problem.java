class Solution {
    // Function to calculate the number of subsets with a given sum
    int n;
    Integer[][]dp;
    public int perfectSum(int[] nums, int sum) {
        // code here
        n = nums.length;
        dp = new Integer[n+1][sum+1];
        return solve(nums,sum,0);
    }
    public int solve(int[] nums,int sum,int i){
        if (i == n) {
            return (sum == 0) ? 1 : 0;
         }
        if(dp[i][sum]!= null) return dp[i][sum];
        int include = 0;
        if(nums[i]<=sum){
            include = solve(nums,sum-nums[i],i+1);
        }
        int exclude = solve(nums, sum, i+1);
        return dp[i][sum] = include+exclude;

    }
}