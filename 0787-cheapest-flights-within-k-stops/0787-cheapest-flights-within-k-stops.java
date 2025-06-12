class Solution {    // Bellman Ford
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        for(int i=0; i<=k; i++){                   // k stops  k+1 edges
            int[] temp = Arrays.copyOf(dist, n); 
            for(int[]flight : flights){
                int u=flight[0];  int v=flight[1];  int wt= flight[2];
                if(dist[u]!=Integer.MAX_VALUE && temp[v]>dist[u]+wt){
                    temp[v] = dist[u]+wt;
                }
            }
            dist = temp;
        }
        return (dist[dst]== Integer.MAX_VALUE)?-1:dist[dst];
    }
}


//If you update dist[v] and then use that updated value in the same iteration, you risk including paths with more
// than k + 1 edges. 