class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(char c : s.toCharArray()){
            if(c == ')') count--;
            if(count>0) sb.append(c);
            if(c=='(') count++;
        }
        return sb.toString();
    }
}