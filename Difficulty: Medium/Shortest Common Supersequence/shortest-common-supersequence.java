// User function Template for Java

class Solution {
    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        int m= s1.length();   int n= s2.length();
        int[][]dp = new int[501][501];
        for(int i=0; i<501; i++) Arrays.fill(dp[i],-1);
        return solve(s1,s2,dp,0,0);
    }
    public static int solve(String s1, String s2,int[][]dp,int i, int j){
        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;
        if(dp[i][j]!= -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) dp[i][j]= 1+solve(s1,s2,dp,i+1,j+1);
        else dp[i][j] = 1+ Math.min(solve(s1,s2,dp,i+1,j),solve(s1,s2,dp,i,j+1));
       
        return dp[i][j];
    }
}