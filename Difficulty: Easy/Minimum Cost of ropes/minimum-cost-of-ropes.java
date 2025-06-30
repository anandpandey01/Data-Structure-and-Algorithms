class Solution {
    public static int minCost(int[] arr) {
        // code here
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val: arr){
            pq.offer(val);
        }
        int cost = 0;
        while(pq.size()>1){
            int min1 = pq.poll();
            int min2 = pq.poll();
            int sum = min1+min2;
            cost+=sum;
            pq.offer(sum);
            
        }
        return cost;
    }
}