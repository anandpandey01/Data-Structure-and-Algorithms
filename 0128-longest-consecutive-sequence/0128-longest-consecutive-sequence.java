class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int res=0;
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        for( int x: hs){
            if(!hs.contains(x-1)){
                int count=1;
                while(hs.contains(x+1)){
                    count++;
                    x=x+1;
                }
                res= Math.max(res, count);
            }
        }
        return res;
    }
}