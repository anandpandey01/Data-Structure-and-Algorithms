class Solution {
    public boolean check(int[] nums) {
        int res= 0,n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)% n]){
                res++;
            }
        }
        return (res==0 || res==1)?true:false;
    }
}