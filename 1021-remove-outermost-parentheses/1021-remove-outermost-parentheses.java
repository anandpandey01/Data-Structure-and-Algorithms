class Solution {
    public String removeOuterParentheses(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (c == ')') {
            st.removeFirst();  
        }
        if (!st.isEmpty()) {
            sb.append(c);  
        }
        if (c == '(') {
            st.addFirst(c);  
        }      
    }

    return sb.toString();
    }
}