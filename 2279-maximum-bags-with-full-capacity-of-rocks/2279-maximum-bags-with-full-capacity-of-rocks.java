class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] required = new int[n];
        for(int i=0; i<n; i++){
            required[i] = capacity[i]-rocks[i];
        }
        int maxBags = 0;
        Arrays.sort(required);
        int j=0;
        while(j<n && additionalRocks >= required[j]){
            additionalRocks = additionalRocks-required[j];
            maxBags++; j++;
        }
        return maxBags;
    }
}