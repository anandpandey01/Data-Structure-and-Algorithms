class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) return result;
        if (n == 1) return Arrays.asList(nums[0]);
        
        int candidate1 = 0,  count1 = 0;
        int candidate2 = 0,  count2 = 0;
        for(int i=0; i<n; i++){     
            if (nums[i] == candidate1) count1++;
            else if (nums[i] == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }  
        }
        // Verification
        count1 = 0; count2 =0;
        for(int i=0; i<n; i++){
            if(nums[i] == candidate1) count1++;
            if(nums[i] == candidate2) count2++;
        }
        int k = n/3;
        if(count1 > k) result.add(candidate1);
        if(candidate2 != candidate1 && count2 > k) result.add(candidate2);  //Note
        // nums = [0, 0, 0]

        return result;
    }
}