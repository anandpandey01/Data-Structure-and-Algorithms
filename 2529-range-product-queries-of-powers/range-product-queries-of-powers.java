class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = (int)(1e9 + 7);
        List<Long> powers = new ArrayList<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) { // i-th bit is set
                powers.add((long)(1 << i));
            }
        }
        int j=0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            long product = 1;
            for (int i = start; i <= end; i++) {
                product = (product * powers.get(i)) % MOD;
            }
            result[j++] = (int)product;
        }
        return result;
    }
}