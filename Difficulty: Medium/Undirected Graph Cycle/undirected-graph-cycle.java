class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean visited [] = new boolean[V];
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0; i<V; i++){
            if(visited[i]== false){
                if(dfs(adj,visited,i,-1) == true) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean [] visited,int u,int parent){
        visited[u] = true;
        for(int v: adj.get(u)){
            if(visited[v]==false){
                if(dfs(adj,visited,v,u) == true){
                    return true;
                }
            }
            else if(v != parent){
                    return true;
            }
        }
        return false;
    }
    
}