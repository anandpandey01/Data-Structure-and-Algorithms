// User function Template for Java

class Solution {               // DFS
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean visited[] = new boolean[V];
        int count=0;
        for(int i=0; i<V; i++){
            if(visited[i] == false){
                dfs(adj,V,visited,i);
                count++;
            }
        }
        return count;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int V, boolean visited[],int u) {
        for(int v=0; v<V; v++){
            if(visited[v]==false && adj.get(u).get(v)==1){
                visited[v] = true;
                dfs(adj,V,visited,v);
            }
        }
    }
};