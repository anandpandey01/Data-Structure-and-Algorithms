class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j=0,res=0;
        for(int i=0;i<nums.length;i++){        
            if(nums[i]==1){
                j++;
                res = Math.max(res,j); 
            }
            else{
                j=0;
            }
        }
        return res;
    }
}