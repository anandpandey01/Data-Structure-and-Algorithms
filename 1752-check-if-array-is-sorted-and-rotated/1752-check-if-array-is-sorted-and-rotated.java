class Solution {
    public boolean check(int[] nums) {
        int res= 0,n=nums.length;
        if(nums[n-1]> nums[0])
            res++;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                res++;
            }
        }
        return (res==0 || res==1)?true:false;
    }
}