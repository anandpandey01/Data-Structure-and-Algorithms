class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if(n==1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            pq.offer(stones[i]);
        }
        int weight = 0;
        while(pq.size()>1){
            int max = pq.poll();
            int secondmax = pq.poll();
            if(max== secondmax)  continue;
            max = max-secondmax;
            pq.offer(max);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}