class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int []color = new int[V];
        for(int i=0; i<V; i++){
            color[i] = -1;
        }
        for(int i=0; i<V; i++){
            if(color[i]==-1){
                if(bfs(graph,color,i) == false) return false;
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph, int[] color, int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        color[s] = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v : graph[u]){
                if(color[v] == -1) {
                    queue.offer(v);
                    color[v] = 1-color[u];
                }
                else if(color[v]==color[u]){
                    return false;
                }
            }
        }
        return true;
    }
    
}