class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(); int n= text2.length();
        int[][]dp = new int[m+1][n+1];
        for(int row=0; row<m+1; row++)  dp[row][0]=0;
        for(int col=0; col<n+1; col++)  dp[0][col]=0;

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(text1.charAt(i-1)== text2.charAt(j-1)) dp[i][j] = 1+ dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        // If You want to Print 
        StringBuilder lcs = new StringBuilder();
        int i=m, j=n;
        while( i >0 && j >0){
            if(text1.charAt(i-1)== text2.charAt(j-1)){
                lcs.append(text1.charAt(i-1));
                i--; j--;                                   // Will go diagonally
            } 
            else{
                if(dp[i-1][j]>dp[i][j-1]) i--;              // Whichever is greater
                else j--;
            }
        }
        lcs.reverse();
        System.out.println(lcs);   //check in stdout
        // End
        
        return dp[m][n];
    }
}

//dp[i][j]= Longest Common Subsequence between s1 of length m and s2 of length n
// i-1 because length 1 means index 0