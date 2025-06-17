// User function Template for Java

class Solution {
    String longestPalindrome(String s) {
        // code here
        int n = s.length();
       int[][]dp = new int[1001][1001];
       for(int i=0; i<1001; i++) Arrays.fill(dp[i],-1);
       
       int length=0;
       int startingPoint=0;

       for(int i=0; i<n; i++){
           for(int j=i; j<n; j++){      
               if(isPalindrome(s,dp,i,j)){   
                   if(j-i+1 > length){
                      length= j-i+1;
                      startingPoint=i;
                   }
               }
           }
       }
       return s.substring(startingPoint,startingPoint+length);
    }
    
    public boolean isPalindrome(String s, int[][]dp, int i, int j){
        if(i>=j) return true;
        if(dp[i][j]!= -1) return dp[i][j]==1;
        if(s.charAt(i)== s.charAt(j)){
            dp[i][j] = isPalindrome(s,dp,i+1,j-1)? 1:0;
        }
        else{
            dp[i][j]= 0;
        }
        return (dp[i][j]==1);
    }
}