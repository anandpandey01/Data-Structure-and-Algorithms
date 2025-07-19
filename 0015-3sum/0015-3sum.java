class Solution {
    List<List<Integer>>  result;
    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if(n < 3) return result;

        for(int i=0; i<n; i++){                               // Fixing the Element
            if( i > 0 && nums[i] == nums[i-1])   continue;    // Removing Duplicates
            int n1 = nums[i];
            int target = -n1;
            twoSum(nums, target, i+1, n-1);
        }
        return result;
    }
    public void twoSum(int[] nums, int target, int i, int j){
        while(i < j){
            if(nums[i] + nums[j] > target) i++;
            else if(nums[i] + nums[j] < target) j--;
            else{
                while(i < j && nums[i] == nums[i+1]) i++;
                while(i < j && nums[j] == nums[j-1]) j--;
                List<Integer> row = new ArrayList<>();
                row.add(-target); row.add(nums[i]); row.add(nums[j]); 
                result.add(new ArrayList<>(row));
                i++; j--;
            }
        }
    }
}