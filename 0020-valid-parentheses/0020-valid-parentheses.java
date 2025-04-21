class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if((c=='(') || (c=='{') || (c=='(')){
                st.push(c);
            }
            else{
                while(!st.isEmpty() && matching(st.peek(),c)){
                    st.pop();
                }
            }
        }
        return (st.isEmpty());
        
    }
    boolean matching(char a, char b){
        return((a=='(')&& b==')')
                || ((a=='{')&& b=='}')
                || ((a=='[')&& b==']');
    }
}
    