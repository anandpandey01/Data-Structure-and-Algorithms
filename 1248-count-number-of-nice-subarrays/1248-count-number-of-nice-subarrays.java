class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0,1);
        int i = 0, oddCountSum = 0;
        int result = 0;
        while(i < n){
            oddCountSum += (nums[i] % 2); // if odd - 1, even - 0
            if(hs.containsKey(oddCountSum - k)){
                result+=hs.get(oddCountSum - k);
            }
            hs.put(oddCountSum,hs.getOrDefault(oddCountSum,0)+1);
            i++;
        }
        return result;
    }
    //Subset Sum = k for count;
}