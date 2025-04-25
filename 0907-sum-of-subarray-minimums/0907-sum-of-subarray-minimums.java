class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length; int mod = (int)(1e9+7);int total=0;
        int[] nse = calculateNSE(arr,n);
        int[] pse = calculatePSE(arr,n); 
        for(int i=0;i<n;i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            total = (total + (right*left*arr[i]) % mod) % mod;
        }
        return total;
    }
    public int[] calculateNSE(int []arr,int n){
        int[] nse = new int[n];
        Stack<Integer> st1 = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st1.isEmpty() && arr[i]<=arr[st1.peek()]){
                st1.pop();
            }
            nse[i] = st1.isEmpty()? n:st1.peek();
            st1.push(i);       
        }
        return nse;
    }
    public int[] calculatePSE(int []arr,int n){
        int[] pse = new int[n];
        Stack<Integer> st2 = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st2.isEmpty() && arr[i]<arr[st2.peek()]){
                st2.pop();
            }
             pse[i] =  st2.isEmpty()?-1:st2.peek();
            st2.push(i);
        }
        return pse;
    }
}