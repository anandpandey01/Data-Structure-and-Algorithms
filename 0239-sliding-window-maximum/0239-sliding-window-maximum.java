class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length,z=0;
        int res[] = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        res[z++] = arr[dq.peekFirst()];  
        for(int i=k; i<n; i++){

            while(!dq.isEmpty() && dq.peekFirst()<=i-k ){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            res[z++] = arr[dq.peekFirst()];
        }
        return res;
    }
}