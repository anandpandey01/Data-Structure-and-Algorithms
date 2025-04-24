class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hs =  new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>st.peek()){
                st.pop();
            }
            int ng = (st.isEmpty())?-1:st.peek();
            hs.put(nums2[i],ng);
            st.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = hs.get(nums1[i]);
        }
        return result;

    }
}