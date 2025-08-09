class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        int n = arr.length;
        int i = 0, j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while(i < n){
            pq.offer(arr[i]);
            if(pq.size() > k){
                arr[j++] = pq.poll();
            }
            i++;
        }
        while(!pq.isEmpty()){                // For Rearranging the last K
            arr[j++] = pq.poll();
        }
        
    }
}
