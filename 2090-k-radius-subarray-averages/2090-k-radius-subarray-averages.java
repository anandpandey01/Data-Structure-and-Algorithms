class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int window_size = (2*k+1);
        int[] result = new int[n];
        Arrays.fill(result, -1);
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for(int i=1; i<n; i++) prefixSum[i] = prefixSum[i-1]+nums[i];

        for(int i=k; i<n-k; i++){
            int left = i-k-1;
            int right = i+k;
            long value = 0;
            value = value + prefixSum[right];
            if(left >= 0) value = value - prefixSum[left];
            result[i] = (int)(value/window_size);
        }
        return result;
    }
}