class Solution {   //Using PrefixSum Approach
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0,1);    // Imp Note
        int i=0, prefixSum = 0;
        int count = 0;
        while(i < n){
            prefixSum += nums[i];
            if(hs.containsKey(prefixSum - goal)){
                count+= hs.get(prefixSum - goal);
            }
            hs.put(prefixSum, hs.getOrDefault(prefixSum,0)+1);
            i++;
        }
        return count;
    }
}