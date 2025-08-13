class Solution {
    int MOD = (int)(1e9+7);
    public int countGoodNumbers(long n) {
        long oddplace =  n/2;
        long evenplace = (n+1)/2;
        long part1 = solve(4, oddplace);
        long part2 = solve(5, evenplace); 
        return (int) ((part1 * part2) % MOD);
        
    }
    public long solve(long x, long n) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
            return solve((x % MOD) * (x % MOD) % MOD, n / 2) % MOD;
        }
        return ((x % MOD) * solve((x % MOD) * (x % MOD) % MOD, n / 2) % MOD) % MOD;
    }
}