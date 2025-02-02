class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int temp [] =  new int[n];
        int k=1;
        temp[0] = nums[0];
        for(int i=0;i<n-1;i++){
            if(nums[i+1]!=nums[i]){
                temp[k] = nums[i+1];
                k++;
            }
        }
        for(int i=0;i<k;i++)    
            nums[i] = temp[i];
        return k;   
    }
}