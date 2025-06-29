// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        while(i<n){
            if(pq.size()<k){
                pq.offer(arr[i]);
            }
            else if(arr[i]<pq.peek()){
                pq.poll();
                pq.offer(arr[i]);
            }
            i++;
        }
        return pq.peek();
        
    }
}
