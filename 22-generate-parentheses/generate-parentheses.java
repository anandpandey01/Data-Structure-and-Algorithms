class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0, n, sb);
        return result;
    }
    public void solve(int i, int n, StringBuilder sb){
        if(i == (2 * n)){
            if(isValid(sb)){
                result.add(sb.toString());
            } 
            return;
        }
        solve(i+1, n, sb.append('('));
        sb.deleteCharAt(sb.length()-1);
        solve(i+1, n, sb.append(')'));
        sb.deleteCharAt(sb.length()-1);
    }
    public boolean isValid(StringBuilder sb){
        int count = 0;
        for(char ch : sb.toString().toCharArray()){
            if (ch == '(') count++;
            else if (ch == ')') count--;
            if (count < 0) return false; // invalid early
        }
        return (count == 0);
    }

}