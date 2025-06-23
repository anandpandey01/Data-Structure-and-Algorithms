class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int count =1, minValue = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]-minValue <= k){
                continue;
            }
            else{
                count++;
                minValue = nums[i];
            }
        }
        return count;
    }
}