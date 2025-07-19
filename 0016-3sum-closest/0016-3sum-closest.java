class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        Arrays.sort(nums);

        for(int k=0; k < n; k++){        //Fix One Element 
           int i = k+1, j = n-1;   
            while(i < j){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(target-sum) < Math.abs(target - res))  res = sum;

                if(sum < target) i++;
                else j--;
            }
        }
        return res;
    }

}