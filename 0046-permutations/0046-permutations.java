class Solution {
    int n;
    HashSet<Integer> hs;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        hs = new HashSet<>();
        solve(nums,temp,result);
        return result;
    }
    public void solve(int[] nums,List<Integer> temp,List<List<Integer>> result){
        if(temp.size() == n){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<n; i++){
            if(!hs.contains(nums[i])){
                temp.add(nums[i]);
                hs.add(nums[i]);
                solve(nums,temp,result);
                temp.remove(temp.size() - 1);
                hs.remove(nums[i]);
            }
        }
    }
}