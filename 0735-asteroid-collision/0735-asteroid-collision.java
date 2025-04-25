class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 || st.isEmpty()) {
                st.push(arr[i]);
            } else {
                while (!st.isEmpty()) {
                    int top = st.peek();
                    int abs = Math.abs(arr[i]);
                    if(top<0){
                        st.push(arr[i]);
                        break;
                    }
                    if (abs > top) {
                        st.pop();
                        if (st.isEmpty()) {
                            st.push(arr[i]);
                            break;
                        }
                    } else if (abs == top) {
                        st.pop();
                        break;
                    } else if (abs < top) {
                        break;
                    }
                }
            }
        }
        int []res =  new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            res[i] = st.get(i);
        }
        return res;
    }
}