class Solution {
    public boolean isBipartite(int[][] graph) {
      int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(graph, i, color, 0) == false)
                    return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int node, int[] color, int currColor) {
        color[node] = currColor;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == color[node])
                return false;

            if (color[neighbor] == -1) {
                if (dfs(graph, neighbor, color, 1 - currColor) == false)
                    return false;
            }
        }
        return true;
    }
}