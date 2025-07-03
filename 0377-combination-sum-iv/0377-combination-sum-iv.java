class Solution {
    public int combinationSum4(int[] nums, int target) {
        return solve(nums,target,0);
    }
    public int solve(int[] nums, int target,int idx){
        if(target<0) return 0;
        if(target == 0) return 1;
        if(idx >= nums.length) return 0;
        int take = solve(nums,target-nums[idx],0); // Imp because of 1,3 and 3,1 idx start from 0 for each take
        int skip = solve(nums,target,idx+1);
        return take+skip;
    }
}