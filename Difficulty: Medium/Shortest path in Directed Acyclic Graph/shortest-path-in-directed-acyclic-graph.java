// User function Template for Java
class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int[] v : adjList.get(u)) {
                indegree[v[0]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] neighbour : adjList.get(u)) {
                int v = neighbour[0];
                int wt = neighbour[1];
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                }
                indegree[v]--;
                if (indegree[v] == 0)  queue.offer(v);
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }
}