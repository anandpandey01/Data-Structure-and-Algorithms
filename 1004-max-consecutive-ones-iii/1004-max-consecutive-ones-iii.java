class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i=0, j=0;
        int zeros = 0, result = 0;

        while(j < n){
            if(nums[j] == 0) zeros++;
            if(zeros > k){
                if(nums[i]== 0)   zeros--;
                i++;
            }
            if(zeros <= k) {
                int len = j-i+1;
                result = Math.max(result,len);
            }
            j++;
        }
        return result;
    }
}