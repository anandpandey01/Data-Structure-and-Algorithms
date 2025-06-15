class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp = new int[1001][1001];
        for(int i=0; i<1001; i++) Arrays.fill(dp[i],-1);
        return solve(text1, text2, dp, 0, 0);
    }
    public int solve(String text1, String text2, int[][]dp, int i, int j){
        if(i>=text1.length() || j>= text2.length()) return 0;
        if(dp[i][j]!= -1) return dp[i][j];

        if(text1.charAt(i)== text2.charAt(j)) dp[i][j]=  1+solve(text1, text2, dp, i+1, j+1);
        else{
            dp[i][j]=  Math.max(solve(text1, text2, dp, i+1, j),solve(text1, text2, dp, i, j+1));
        }
        return dp[i][j];

    }
}