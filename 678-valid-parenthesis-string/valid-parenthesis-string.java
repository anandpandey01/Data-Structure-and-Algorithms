class Solution {
    public boolean checkValidString(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n+1][n+1];

    dp[n][0] = true; // Base case: at the end of string, only count == 0 is valid
    for (int i = n - 1; i >= 0; i--) {
        for (int count = 0; count <= n; count++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (count + 1 <= n) {
                    dp[i][count] = dp[i + 1][count + 1];
                }
            } 
            else if (ch == ')') {
                if (count - 1 >= 0) {
                    dp[i][count] = dp[i + 1][count - 1];
                }
            } 
            else {
                boolean case1 = (count+1 <= n) && dp[i+1][count+1]; 
                boolean case2 = dp[i+1][count];                        
                boolean case3 = (count - 1 >= 0) && dp[i+1][count-1]; 
                dp[i][count] = case1 || case2 || case3;
            }
        }
    }
    return dp[0][0];
    }
}