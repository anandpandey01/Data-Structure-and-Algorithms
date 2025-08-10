class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        int close = 0;
        int n = s.length();
        
        // Left to Right - Check Open Brackets
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                open++;
            } else {
                open--;
            }
                
            if (open < 0) {
                return false;
            }
        }

        // Right to Left - Check Close Brackets
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                close++;
            } else {
                close--;
            }
            
            if (close < 0) {
                return false;
            }
        }
        
        return true;
    }
}