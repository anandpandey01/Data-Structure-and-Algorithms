class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int start_i = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0; i<n; i++){
            if(hs.containsKey(nums[i])){
                int j = hs.get(nums[i]);
                if(Math.abs(j-i)<= k) return true;
            }
            hs.put(nums[i],i);
        }
        return false;
    }
}