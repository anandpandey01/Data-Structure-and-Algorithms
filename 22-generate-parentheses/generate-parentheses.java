class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int open = 0, close = 0;
        solve(0, n, sb, open, close);
        return result;
    }
    public void solve(int i, int n, StringBuilder sb, int open, int close){
        if(i == (2 * n)){
            result.add(sb.toString());
            return;
        }
        if (open < n) { 
            solve(i+1, n, sb.append('('), open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close < open) {
            solve(i+1, n, sb.append(')'), open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}