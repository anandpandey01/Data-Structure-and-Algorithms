class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;

        int prefix  = 1, suffix = 1;
        for(int i=0; i<n; i++){
            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];
            res = Math.max(res, Math.max(prefix, suffix));
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
        }
        return res;
    }
}