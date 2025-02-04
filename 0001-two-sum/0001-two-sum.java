class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        int first =-1, second =-1;
        for(int i=0;i<nums.length;i++){
              if(hs.containsKey(target-nums[i])){
                 first = hs.get(target-nums[i]);
                 second = i;
            }
             hs.put(nums[i],i);
        }
        return new int []{first,second};
    }
}