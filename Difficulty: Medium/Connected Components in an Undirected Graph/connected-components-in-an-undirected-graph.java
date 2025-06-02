
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(visited[i]==false){
                ArrayList<Integer> row = new ArrayList<>();
                dfs(adj,visited,i,row);
                result.add(row);
            }
        }
        return result;
    }
     public void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[],int u,List<Integer> row) {
         visited[u] = true;
         row.add(u);
         for(int v : adj.get(u)){
             if(visited[v]== false){
                 visited[v] = true;
                 dfs(adj,visited,v,row);
             }
         }
     }
}