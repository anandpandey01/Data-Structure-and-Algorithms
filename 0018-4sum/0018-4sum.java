class Solution {
    List<List<Integer>>  result;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n; i++){                               // Fixing the Element
            if( i > 0 && nums[i] == nums[i-1])   continue;    // Removing Duplicates                         
            for(int j = i+1; j<n; j++){
                if( j > i+1 && nums[j] == nums[j-1])   continue;    // Removing Duplicates
                int n1 = nums[i];  int n2 = nums[j];
                int reqtarget = target -(n1 + n2);
                twoSum(nums, reqtarget,n1,n2, j+1, n-1);
            }                           
        }
        return result;
    }

    public void twoSum(int[] nums, int target, int n1, int n2, int i, int j){
        while(i < j){
            if(nums[i] + nums[j] > target) j--;
            else if(nums[i] + nums[j] < target) i++;
            else{
                while(i < j && nums[i] == nums[i+1]) i++;
                while(i < j && nums[j] == nums[j-1]) j--;
                List<Integer> row = new ArrayList<>();
                row.add(n1); row.add(n2); row.add(nums[i]); row.add(nums[j]); 
                result.add(new ArrayList<>(row));
                i++; j--;
            }
        }
    }
}