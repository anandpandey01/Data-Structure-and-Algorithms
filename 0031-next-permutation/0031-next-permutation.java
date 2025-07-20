class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int first_greater = -1;
        // Traverse from right to left and find the first element where arr[i-1] < arr[i] 
        for(int i=n-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                first_greater = i-1;   
                break;
            }
        }
        // Find the number to Swap With     
        if(first_greater != -1){
            int swap_index = -1;
            for(int j= n-1; j>= first_greater; j--){
            if(nums[j] > nums[first_greater]){
                swap_index = j;
                break;
                }   
            }
            if(swap_index != -1){
                int temp = nums[swap_index];
                nums[swap_index] = nums[first_greater];
                nums[first_greater] = temp;
            }
        }
            
        // Reverse the array from first_greater+1
        int i = first_greater+1, j = n-1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}