class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        Map<Integer, Integer> hs = new HashMap<>();
        int xor = 0;
        long count = 0;

        for (int num : arr) {
            xor ^= num;
            if (xor == k) count++;
            int required = xor ^ k;
            count += hs.getOrDefault(required, 0);
            hs.put(xor, hs.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}