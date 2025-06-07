class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjList.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int []dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new int[]{src,0});
        dist[src] = 0;
        while(!pq.isEmpty()){
            int []node = pq.poll();
            int value = node[0];
            int d = node[1];
            for(int[] neighbour: adjList.get(value)){
                int v  = neighbour[0];
                int wt = neighbour[1];
                if(dist[v]>dist[value]+wt){
                    dist[v]= dist[value]+wt;
                    pq.offer(new int[]{v,dist[v]});
                }
       
            }
        }
        return dist;
    }
}