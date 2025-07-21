class Solution {
    int maxLength(int arr[]) {
        // code here
        int n = arr.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0,-1);
        int maxLength = 0;
        
        int prefixSum = 0;
        for(int i=0; i<n; i++){
            prefixSum += arr[i];
            if(hs.containsKey(prefixSum - 0)){
                int j = hs.get(prefixSum);
                maxLength = Math.max(maxLength,i-j);  // Subarray Starts from j+1
            }
            if(!hs.containsKey(prefixSum)){
                hs.put(prefixSum, i);
            }
        }
        return maxLength;
        
    }
}