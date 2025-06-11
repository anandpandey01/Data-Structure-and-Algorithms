
class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int V = adj.size();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        int[] result = new int[V];
        Arrays.fill(result,-1);
        result[src] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int v : adj.get(node)){
                if(result[v]==-1){
                    result[v] = result[node]+1;
                    queue.offer(v);
                }
            }
        }
        return result;
    }
}
