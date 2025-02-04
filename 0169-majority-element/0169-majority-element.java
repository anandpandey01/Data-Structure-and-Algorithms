class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int k = (int) Math.ceil(n/2);
        Arrays.sort(nums);
        return nums[n/2];
        
    }
}