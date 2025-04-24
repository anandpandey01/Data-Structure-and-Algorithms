class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        int[]res = new int[n];
        for(int i=(2*n-1);i>0;i--){
            while(!st.isEmpty() && arr[i%n]>=st.peek()){
                st.pop();
            }
            int ng = st.isEmpty()?-1:st.peek();
            res[i%n]= ng;
            st.push(arr[i%n]);
        }
        return res;
    }
}