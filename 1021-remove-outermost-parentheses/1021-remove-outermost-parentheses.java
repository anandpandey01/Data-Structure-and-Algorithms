class Solution {
    public String removeOuterParentheses(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c=='(' ){
               if(!st.isEmpty()) {
                  sb.append(c);
               }
               st.push(c);
            }
            else{
                st.pop(); 
                if(!st.isEmpty()) {
                  sb.append(c);
               }
            }

        }
        return sb.toString();
    }
}