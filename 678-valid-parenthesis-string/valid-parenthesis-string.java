class Solution {
    int n;
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        n = s.length();
        dp = new Boolean[n][n+1];
        return solve(s, 0, 0);
    }
    public boolean solve(String s, int i, int count){
        if(count < 0) return false;
        if(i == n && count == 0) return true;
        if(i == n) return false;
        if(dp[i][count] != null) return dp[i][count];

        boolean isValid = false;
        if(s.charAt(i) == '(') isValid = isValid || solve(s, i+1, count+1);
        if(s.charAt(i) == ')') isValid = isValid || solve(s, i+1, count-1);
        
        if(s.charAt(i) == '*'){
            isValid = isValid || solve(s, i+1, count+1);
            isValid = isValid || solve(s, i+1, count);
            isValid = isValid || solve(s, i+1, count-1);
        }
        return dp[i][count] = isValid;

    }
}
