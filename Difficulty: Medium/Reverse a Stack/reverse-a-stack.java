
class Solution {
    static void reverse(Stack<Integer> st) {
        // code here
        if(st.size() < 1) return;
        int x = st.pop();
        reverse(st);
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        st.push(x);
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        
        
    }
}