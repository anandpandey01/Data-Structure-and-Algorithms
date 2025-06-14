class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][n + 1]; // dp[i][prevIndex]
        for (int[] row : dp) Arrays.fill(row, -1);
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int prev = -1; // Initially Temp is empty
        solve(nums,result,n,temp,0,prev,dp);
        return result;

    }
    public int solve(int[] nums,List<Integer> result,int n,List<Integer> temp,int i,int prevIndex,int[][] dp){
        if(i>= n){
            if(temp.size()> result.size()) {
                result.clear();
                result.addAll(temp);
            }
            return 0;
        }
        if (dp[i][prevIndex + 1] != -1) return dp[i][prevIndex + 1];
        // Take
        int taken=0;
        if(prevIndex== -1 || nums[i] % nums[prevIndex] == 0){
            temp.add(nums[i]);
            taken= 1+ solve(nums,result,n,temp,i+1,i,dp);
            temp.remove(temp.size() - 1);    // For Not Take
        }
        int skip = solve(nums,result,n,temp,i+1,prevIndex,dp);
        return dp[i][prevIndex + 1] = Math.max(taken, skip);
        
    }
}