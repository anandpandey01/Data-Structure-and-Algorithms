class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    private int atMostKDistinct(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hs = new HashMap<>();
        
        int i=0, j=0;
        int result = 0;
        while(j < n){
            hs.put(nums[j],hs.getOrDefault(nums[j],0)+1);
            while(hs.size() > k){
                hs.put(nums[i], hs.getOrDefault(nums[i],0)-1);
                if(hs.get(nums[i]) == 0) hs.remove(nums[i]);
                i++;
            } 
            result += j - i + 1;
            j++;
        }
        return result;
    }
}