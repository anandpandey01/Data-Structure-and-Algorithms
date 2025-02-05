class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum=nums[0],res=nums[0];
        for(int i=1;i<nums.length;i++){
            if(curr_sum < 0)
                curr_sum=0;
            curr_sum = curr_sum + nums[i];
            res= Math.max(curr_sum,res);
        }
        return res;
    }
}