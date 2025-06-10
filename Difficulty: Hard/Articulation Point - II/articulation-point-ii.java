class Solution {
    private static int time=0;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
         // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges){
            int u = edge[0]; int v= edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
       
        int[] disc = new int[V];   // Discovery time
        int[] low =  new int[V];   // Lowest reachable time
        boolean[] visited = new boolean[V];
        HashSet<Integer> articulationPoints = new HashSet<>();  // To avoid Duplicates
        
        for(int i=0; i<V; i++){
            if(visited[i] == false){
                dfs(-1,i,adj,disc,low,visited,articulationPoints);
            }
        }
        ArrayList<Integer> result = new ArrayList<>(articulationPoints);
        if (result.isEmpty()) result.add(-1);
        else Collections.sort(result);
        return result;   
    }
    public static void dfs(int parent, int u, ArrayList<ArrayList<Integer>> adj,int[] disc, int[] low, boolean[] visited,HashSet<Integer> articulationPoints){
        visited[u]= true;
        disc[u] = low[u] = ++time;
        int children = 0;
        
        for(int v: adj.get(u)){
            if (v == parent) continue;
            if(visited[v] == false){
                children++;
                dfs(u,v,adj,disc,low,visited,articulationPoints);
                low[u] = Math.min(low[u], low[v]);
                // Non-root node condition
                if(low[v]>=disc[u] && parent!= -1)  articulationPoints.add(u);
            }
            else{
                low[u] = Math.min(low[u], disc[v]);   // Back edge
            }
        }
        // Root node special case
        if (parent == -1 && children > 1) {
            articulationPoints.add(u);
        }
    }
}
