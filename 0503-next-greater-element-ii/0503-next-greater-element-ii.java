class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int res[] = new int[n];
        for(int i=(2*n-1);i>=0;i--){
            while(!st.isEmpty() && arr[i%n]>=arr[st.peek()]){
                st.pop();
            }
            int nge = st.isEmpty()?-1:arr[st.peek()];
            st.push(i%n);
            res[i%n] = nge;
        }
        return res;
    }
}