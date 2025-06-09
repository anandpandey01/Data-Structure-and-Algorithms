class Solution {
    public int removeStones(int[][] stones) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int V = stones.length;
        for(int i=0; i<V; i++)  adjList.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                adjList.get(i).add(j);
                adjList.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[V];
        int components=0;
        for(int i=0; i<V; i++){
            if(visited[i]== false){
                dfs(adjList,visited,i);
                components++;
            }
        }
        return V-components;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int u){
        visited[u] = true;
        for(int v:adjList.get(u)){
            if(visited[v]== false){
                dfs(adjList,visited,v);
            }
        }
    }
}