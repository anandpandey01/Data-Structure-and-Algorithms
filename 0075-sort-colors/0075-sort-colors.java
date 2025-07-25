class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0, j=0, k=n-1;               // i - 0, j - 1, k - 2
        while(j <= k){
            if(nums[j] == 0){
                swap(nums,i,j);
                i++; j++;
            }
            else if(nums[j] == 1){
                j++;
            }
            else if(nums[j] == 2){
                swap(nums, j, k);
                k--;
            }
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}