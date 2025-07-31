class Solution {  // Monotonic Stack
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        
        Stack<Integer> st = new Stack<>();
        for(char ch : num.toCharArray()){
            int value = ch - '0';
            while(!st.isEmpty() && st.peek() > value && k > 0){
                st.pop();
                k--;
            }
            st.push(value);
        }
        while(k > 0){
            st.pop(); k--;
        }
        StringBuilder sb = new StringBuilder();
        for(int val : st){
            sb.append(val);                  // Not popping so no need to reverse
        }
        int d = 0;
        String result = "";
        while(d < sb.length() && sb.charAt(d) == '0'){
            d++;
        }
        result = sb.substring(d);
        return (result.isEmpty()) ? "0": result;
    }
}