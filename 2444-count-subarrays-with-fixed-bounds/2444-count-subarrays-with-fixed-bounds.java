class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minKidx = -1, maxKidx = -1;
        int culpritidx = -1;

        long ans = 0;
        for(int i=0; i<n; i++){
            if(nums[i]>maxK || nums[i]<minK)  culpritidx = i;
            if(nums[i] == minK ) minKidx = i;
            if(nums[i] == maxK ) maxKidx = i;   // Not else if because elements can be same

            long smalleridx = Math.min(minKidx,maxKidx);
            long temp = smalleridx - culpritidx;
            ans = ans + ((temp < 0)? 0 : temp);
        } 
        return ans;

    }
}