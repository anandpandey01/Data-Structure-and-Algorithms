class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        // Storing Parent is optional you may chose not to.
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges){
            adjList.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> Integer.compare(a[2],b[2]));
        queue.offer(new int[]{-1,src,0});
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        while(!queue.isEmpty()){
            int[] node= queue.poll();
            int parent = node[0]; int u= node[1]; 
            for(int[] neighbour:adjList.get(u)){
                int v= neighbour[0]; int wt= neighbour[1];
                if(dist[u]!= Integer.MAX_VALUE && (dist[v]> dist[u]+ wt)){
                    dist[v]= dist[u]+ wt;
                    queue.offer(new int[]{u,v,dist[v]});
                }
            }
        }
        return dist;
        
    }
}