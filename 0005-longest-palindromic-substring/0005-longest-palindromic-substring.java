class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][]dp = new int[1001][1001];
        for(int i=0; i<1001; i++) Arrays.fill(dp[i],-1);
        int maxLen=0;
        int sp = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(s,i,j,dp)){
                    if(j-i+1> maxLen){
                        maxLen= j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp,sp + maxLen);
    }
   
    public boolean isPalindrome(String s,int i,int j,int[][]dp){
        if(i>=j) return true;
        if(dp[i][j]!= -1) return dp[i][j]==1;
        if(s.charAt(i) == s.charAt(j)) dp[i][j]= isPalindrome(s,i+1,j-1,dp)? 1: 0;    // 0 is false - 1 is true
        else dp[i][j]= 0;

        return dp[i][j] == 1;     
    }  
}
