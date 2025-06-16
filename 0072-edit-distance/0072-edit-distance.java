class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();  int n= word2.length();
        int[][]dp = new int[501][501];
        for(int i=0; i<501; i++) Arrays.fill(dp[i],-1);
        return solve(word1,word2,dp,m,n,0,0);
    }
    public int solve(String word1, String word2,int[][]dp,int m, int n,int i, int j){
        if(i>=m) return n-j;   // Addition
        if(j>=n) return m-i;   //Deletion
        if(dp[i][j]!= -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)) dp[i][j] = solve(word1,word2,dp,m,n,i+1,j+1);
        else{
            int insert =  1+solve(word1,word2,dp,m,n,i,j+1);
            int delete =  1+solve(word1,word2,dp,m,n,i+1,j);
            int replace = 1+solve(word1,word2,dp,m,n,i+1,j+1);  
            dp[i][j] = Math.min(insert,Math.min(delete,replace));
        }
        return dp[i][j];

    }
}