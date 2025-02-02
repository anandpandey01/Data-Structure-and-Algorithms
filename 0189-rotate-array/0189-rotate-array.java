class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int left=0, right=n-1;
        while(left<=right){
            int temp=nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
        left =0 ; right = (k-1);
          while(left<=right){
            int temp=nums[left];
            nums[left] = nums[right%n];
            nums[right%n] = temp;
            left++; right--;
        }
         left =k ; right = (n-1);
          while(left<=right){
            int temp=nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }



    }
}