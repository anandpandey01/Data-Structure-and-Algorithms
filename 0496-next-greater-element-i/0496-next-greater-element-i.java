class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] arr) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        hs.put(arr[n-1],-1);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]>=st.peek()){
                st.pop();
            }
            int nge = st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
            hs.put(arr[i],nge);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = hs.get(nums1[i]);
        }
           return nums1;
    }
 
}