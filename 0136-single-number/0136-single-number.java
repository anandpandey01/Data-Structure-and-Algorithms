class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        int res=-1;
        for(int x : nums){
            hs.put(x,hs.getOrDefault(x,0)+1);
        }
        for(int x:nums){
            if(hs.get(x)==1)
                res= x;
        }
        return res;
    }
}