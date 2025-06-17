class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][]dp = new int[1001][1001];
        for(int i=0; i<1001; i++) Arrays.fill(dp[i],-1);
        return solve(s, dp, 0, s.length()-1);
    }
    public int solve(String s, int[][]dp, int i, int j){
        if(i>j) return 0; 
        if(i==j) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) dp[i][j]= 2 + solve(s, dp, i+1, j-1);
        else{
            dp[i][j]= Math.max(solve(s, dp, i+1, j), solve(s, dp, i, j-1));
        }
        return dp[i][j];
    }
    
}