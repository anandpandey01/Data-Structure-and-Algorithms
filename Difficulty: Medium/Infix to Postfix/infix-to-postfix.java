//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        HashMap<Character,Integer> h = new HashMap<>();
        h.put('^',1);
        h.put('*',2);
        h.put('/',2);
        h.put('+',3);
        h.put('-',3);
        
        for(char c : s.toCharArray()){
            if(Character.isLetter(c) || Character.isDigit(c)){
                ans.append(c);
            }else{
                if(c=='('){
                    st.push(c);
                }else if(c==')'){
                    while(!st.isEmpty() && st.peek()!='('){
                        ans.append(st.pop());
                    }
                    st.pop();
                }else{
                    if(st.isEmpty()||st.peek()=='('){
                        st.push(c);
                    }else{
                        while(!st.isEmpty() && st.peek()!='(' && h.get(st.peek()) <= h.get(c)){
                            ans.append(st.pop());
                        }
                        st.push(c);
                    }
                }
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        
        return ans.toString();
    }
}