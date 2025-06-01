class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        boolean visited [] = new boolean[adj.size()];
        dfs_helper(adj,visited,result,0);
        return result;
        
    }
    public void dfs_helper(ArrayList<ArrayList<Integer>> adj,boolean visited [],ArrayList<Integer> result,int u){
        visited[u] = true;
        result.add(u);
        for(int v : adj.get(u)){
            if(visited[v] == false){
                dfs_helper(adj,visited,result,v);
            }
        }
    }
    
}