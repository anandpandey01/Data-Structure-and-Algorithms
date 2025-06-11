
class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=v; i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges){
            int a = edge[0]; int b = edge[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        } 
        boolean[] visited = new boolean[v+1];  // Numbered from 1 to V
        int goodComponents=0;
        for(int i=1; i<=v; i++){
            if(visited[i]== false){
                List<Integer> components = new ArrayList<>();
                dfs(adjList,visited,i,components);
                int vertices = components.size();
                int totaledges = 0;
                for(int node : components){
                    totaledges = totaledges+ adjList.get(node).size();
                }
                totaledges = totaledges/2; // For undirected
                if(totaledges == vertices*(vertices-1)/2)  goodComponents++;
            }
        }
        return goodComponents;
        
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adjList,boolean[] visited,int u,List<Integer> components){
        visited[u] = true;
        components.add(u);
        for(int neighbour : adjList.get(u)){
            if(visited[neighbour] == false){
                dfs(adjList,visited,neighbour,components);
            }
        }
    }
}
