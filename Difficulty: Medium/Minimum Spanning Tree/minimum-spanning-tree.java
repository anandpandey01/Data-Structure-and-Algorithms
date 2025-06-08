class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent,-1);
        int mstCost = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.offer(new int[]{-1,0,0});
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int parentNode = node[0], curNode = node[1], weight=node[2];
            
            if (visited[curNode] == true) continue;
            visited[curNode] = true;
            mstCost += weight;
            
            for(int[] neighbour: adj.get(curNode)){
                int adjNode = neighbour[0];
                int edgeWeight = neighbour[1];
                if (visited[adjNode] == false) {
                    pq.offer(new int[]{curNode, adjNode, edgeWeight});
                }
            }
        }
        return mstCost;
    }
}