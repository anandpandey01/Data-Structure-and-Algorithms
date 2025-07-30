class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        List<Integer> row = new ArrayList<>();
        solve(nums, 0, row);
        return result; 
    }
    public void solve(int[] nums, int i, List<Integer> row){
        if(i > n) return;
        if(i == n){
            result.add(new ArrayList<>(row));
            return;
        }
        row.add(nums[i]);
        solve(nums, i+1, row);
        row.remove(row.size()-1);
        solve(nums, i+1, row);

    }
    //  List<Integer> row is not a Primitive Type so backtrack is there unlike Subset Sum Problem
}