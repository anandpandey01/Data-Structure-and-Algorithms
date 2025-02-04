class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length, res=-1;
        int k = (int) Math.ceil(n/2);
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0;i<n;i++){
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }
        for(int x : hs.keySet()){
            if(hs.get(x)>k)
                res=x; 
        }
        return res;
    }
}