class Solution {            //  For Unique Elements
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        
        while(low<high){                    // Imp - If = then stuck in a loop
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }
            else{
                high = mid;                 // Possible answer
            }
        }
        return nums[high];
    }
}