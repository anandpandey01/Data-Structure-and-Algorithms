// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int m = s1.length(), n = s2.length();
        int[] prev = new int[n+1];
        int maxLen = 0;
        
        for(int i=1; i<=m; i++){
            int[] curr = new int[n+1];
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                    maxLen = Math.max(maxLen, curr[j]);
                }
                else{
                    curr[j] = 0;
                }
            }
            prev = curr;
        }
        return maxLen;
    }
}