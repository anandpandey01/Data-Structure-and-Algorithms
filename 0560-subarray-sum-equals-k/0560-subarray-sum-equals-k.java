class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        int prefixSum=0,count=0;
        hs.put(0, 1);
         for(int j=0;j<nums.length;j++){
            prefixSum = prefixSum + nums[j];
            if(hs.containsKey(prefixSum-k)){
                count+=hs.get(prefixSum - k);;
            }
            hs.put(prefixSum,hs.getOrDefault(prefixSum,0)+1);
         }
         return count;
    }
}