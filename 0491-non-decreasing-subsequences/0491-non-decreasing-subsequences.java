class Solution {
    int n;
    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(nums,result,curr,0);
        return result;
    }
    public void solve(int[]nums,List<List<Integer>> result,List<Integer> curr,int idx){
        if(curr.size()>=2) result.add(new ArrayList<>(curr));
        HashSet<Integer> hs = new HashSet<>();
        for(int i=idx; i<n; i++){
            if((curr.size() == 0 || nums[i]>=curr.get(curr.size()-1)) && !hs.contains(nums[i])){
                curr.add(nums[i]);
                solve(nums,result,curr,i+1);
                curr.remove(curr.size() - 1);
                hs.add(nums[i]);
            }
        }
    }
}