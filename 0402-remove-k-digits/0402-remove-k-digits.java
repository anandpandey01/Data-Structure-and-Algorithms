class Solution {
    public String removeKdigits(String str, int k) {
        if(str.length()==k) return "0";
        Stack<Character>st = new Stack<>();
        for(char ch : str.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);    // Not popping so no need to reverse
        }
        int d=0;
        while( d<sb.length() && sb.charAt(d)=='0'){
            d++;
        }
        String res = sb.substring(d);
        return (res.isEmpty())? "0": res;

    }
}