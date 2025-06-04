class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(visited[i]== false){
                if(dfs(V,adjList,visited,i,-1) == true) return true;
            }
        }
        return false;
        
    }
    public boolean dfs(int V, ArrayList<ArrayList<Integer>> adjList,boolean visited[],int s, int parent){
        visited[s]=true;
        for(int v: adjList.get(s)){
            if(visited[v]==false){
               if(dfs(V,adjList,visited,v,s) == true) return true; 
            }
            else if(parent != v) return true;
        }
        return false;
        }
    }