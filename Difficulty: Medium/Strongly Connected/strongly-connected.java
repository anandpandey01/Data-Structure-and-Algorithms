class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        // Step 1 Put it in Stack for Topo Sort order
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(visited[i]==false){
                dfsfill(adj,visited, st, i);
            }
        }
        // Step 2 Reverse the nodes
        ArrayList<ArrayList<Integer>> adjReverse = new ArrayList<>();
        for(int i = 0; i < V; i++) adjReverse.add(new ArrayList<>()); 
        for(int u=0; u<V; u++){
            for(int v: adj.get(u)){
                adjReverse.get(v).add(u);
            }
        }
        //  Step 3 Do a dfs based on Stack order
        Arrays.fill(visited,false);   // Reset
        int components=0;
        while(!st.isEmpty()){
            int v= st.pop();
            if(visited[v] == false){
                dfs(adjReverse,visited,v);
                components++;
            }
        }
        return components;
    }
    
    
    public void dfsfill(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st,int u ){
        visited[u] = true;
        for(int v: adj.get(u)){
            if(visited[v] ==false){
                dfsfill(adj,visited,st,v);
            }
        }
        st.push(u);
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited,int u ){
        visited[u] = true;
        for(int v: adj.get(u)){
            if(visited[v] ==false){
                dfs(adj,visited,v);
            }
        }
    }
}