
class Solution {
    public int countPS(String s) {
        // code here
        int n= s.length();
        int[][]dp = new int[n+1][n+1];
         for (int i = 0; i < n; i++) {
            dp[i][i] = 1;     // initialized for computing others but not counted
        }
        
        int count=0;
        for(int len=2; len<n+1; len++){  //No need to count 1 Len
            for(int i=0; i+len-1<n ;i++){
                int j = i+len-1;
                //if(i==j) dp[i][j] = 1;
                if(i+1 == j) dp[i][j] = (s.charAt(i)==s.charAt(j))?1:0;
                else{
                    dp[i][j] = (dp[i+1][j-1]==1 && s.charAt(i) == s.charAt(j))?1:0;
                }
                if(dp[i][j]==1) count++;
            }
        }
        return count;
    }
}