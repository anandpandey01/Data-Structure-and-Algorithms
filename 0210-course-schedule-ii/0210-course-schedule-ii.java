class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int V = numCourses;
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] neighbour : prerequisites) {
            int u = neighbour[0];
            int v = neighbour[1];
            adjList.get(v).add(u);
        }
        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adjList.get(u)) {
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int v : adjList.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        int[] res = new int[V];
         if (result.size() != numCourses) return new int[0];
        for(int i=0; i<V; i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
