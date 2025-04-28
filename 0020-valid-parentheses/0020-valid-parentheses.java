class Solution {
    public boolean isValid(String s) {
        Stack<Character> st =  new Stack<>();
        for(char c : s.toCharArray()){
            if((c == '{') || (c == '[') ||(c == '(')) st.push(c);
            else{
                if(!st.isEmpty() && isMatching(st.peek(),c)){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return (st.isEmpty());
    }
    public boolean isMatching(char a , char b){
                if((a=='(' && b == ')')  || (a=='{' && b == '}')  ||
                 (a=='[' && b == ']')) {
                    return true;
                 }  
                 else{
                    return false;
                 }
    }
}