class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        int m= s1.length();   int n=s2.length();
        int[][]dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++) Arrays.fill(dp[i],-1);
        return solve(s1,s2,dp,0,0);
    }
    public int solve(String s1, String s2,int[][]dp,int i, int j){
        if(i>=s1.length()) return s2.length()-j;  //Delete
        if(j>=s2.length()) return s1.length()-i;  //Add
        if(dp[i][j]!= -1) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j)) dp[i][j] = solve(s1,s2,dp,i+1,j+1);
        else{
            int insert =  solve(s1,s2,dp,i,j+1);
            int remove =  solve(s1,s2,dp,i+1,j);
            int replace = solve(s1,s2,dp,i+1,j+1);
            dp[i][j] = 1+Math.min(insert,Math.min(remove,replace));
        }
        return dp[i][j];
        
    }
}