class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int []res=new int[101];
        int count=0;
        for(int i=0;i<nums.length;i++){
            count=count+res[nums[i]]++;
        }
        return count;
    }
}