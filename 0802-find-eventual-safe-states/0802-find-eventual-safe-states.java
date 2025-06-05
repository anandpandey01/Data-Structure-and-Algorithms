class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            for (int v : graph[i]) {
                adjList.get(i).add(v);
            }
        }
        boolean visited[] = new boolean[V];
        boolean pathVisited[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(visited[i]== false){
                dfs(adjList,visited,pathVisited,i);
            }
        }
         List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (pathVisited[i] == false) result.add(i);
        }
        return result;
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