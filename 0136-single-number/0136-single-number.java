class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int pointer = nums.length-1,i=nums.length-2;
        while(pointer>0){
                if(nums[i]== nums[pointer]){
                    pointer-=2;
                    i-=2;
                }
                else{
                    return nums[pointer];
                }
        }
        return nums[0];
    }
}