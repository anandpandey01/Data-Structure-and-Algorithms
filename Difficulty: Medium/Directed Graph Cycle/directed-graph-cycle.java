class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean visited[] = new boolean[V];
        boolean pathVisited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        
        for(int i=0; i<V; i++){
            if(visited[i]== false){
                if(dfs(adjList,visited,pathVisited,i) == true) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adjList,boolean visited[],
                        boolean pathVisited[], int u){
        visited[u] = true;
        pathVisited[u] = true;
        for(int v: adjList.get(u)){
            if(visited[v]==false){
                if(dfs(adjList,visited,pathVisited,v) == true) return true;
            }
            else if (pathVisited[v] == true)  return true;
        }
        pathVisited[u]=false;
        return false;
        
                               
    }
}