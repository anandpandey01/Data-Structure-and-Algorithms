class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();  int n= word2.length();
        int[][]dp = new int[501][501];
        for(int i=0; i<501; i++) Arrays.fill(dp[i],-1);
        return solve(word1,word2,dp,m,n);
    }
    public int solve(String word1, String word2,int[][]dp,int m, int n){
        if(m==0) return n;   
        if(n==0) return m;  
        if(dp[m][n]!= -1) return dp[m][n];
        if(word1.charAt(m-1) == word2.charAt(n-1)) dp[m][n] = solve(word1,word2,dp,m-1,n-1);
        else{
            int insert =  1+solve(word1,word2,dp,m,n-1);
            int delete =  1+solve(word1,word2,dp,m-1,n);
            int replace = 1+solve(word1,word2,dp,m-1,n-1);  
            dp[m][n] = Math.min(insert,Math.min(delete,replace));
        }
        return dp[m][n];

    }
}