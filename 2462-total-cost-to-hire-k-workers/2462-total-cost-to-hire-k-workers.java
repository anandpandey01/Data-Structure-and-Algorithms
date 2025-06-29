class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> minheap1 = new PriorityQueue<>();
        PriorityQueue<Integer> minheap2 = new PriorityQueue<>();
        int hired=0, i=0, j=n-1;
        int cost=0;
        while(hired<k){

            while(minheap1.size()<candidates && i<=j){
                minheap1.offer(costs[i]); i++;
            }
            while(minheap2.size()<candidates && j>=i){
                minheap2.offer(costs[j]); j--;
            }
            int min1 = (minheap1.isEmpty()?Integer.MAX_VALUE:minheap1.peek());
            int min2 = (minheap2.isEmpty()?Integer.MAX_VALUE:minheap2.peek());
            if(min1<=min2){        // If they get equal take based on index
                cost+=min1;
                minheap1.poll();
            }
            else{
                cost+=min2; 
                minheap2.poll();
            }      
            hired++;
        }
        return cost;
        
    }
}