class Solution {
    public int[] twoSum(int[] nums, int target) {
        int first =-1, second =-1,sum=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                sum=nums[i]+ nums[j];
                if(sum== target){
                    first =i;second=j;
                }
            }
        }
        return new int[]{first,second};
    }
}