// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src]=0;
        
        for(int i=0; i<V-1; i++){
            for(int[] edge : edges){
                int u =  edge[0];
                int v =  edge[1];
                int wt = edge[2];
                if(dist[u] != (int)1e8){
                    if(dist[v]>dist[u]+wt ){
                       dist[v]=dist[u]+wt;
                    }
                }
            }
        }
        for(int[] edge : edges){
                int u =  edge[0];
                int v =  edge[1];
                int wt = edge[2];
                if(dist[u] != (int)1e8){
                    if(dist[v]>dist[u]+wt ){
                       return new int[]{-1}; // Negative cycle detected
                    }
                }
            }
        return dist;
    }
}
