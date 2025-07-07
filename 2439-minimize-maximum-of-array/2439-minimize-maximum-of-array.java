class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int ans = 0;
    
    for (int i = 0; i < n; i++) {
        sum += nums[i];
        int avg = (int)((sum + i) / (i + 1));   // ceiling of average
        ans = Math.max(ans, avg);
    }
    
    return ans;
    }
}