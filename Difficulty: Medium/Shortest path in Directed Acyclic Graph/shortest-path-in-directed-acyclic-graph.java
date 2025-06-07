// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int u =  node[0];
            int d = node[1];
            for(int[] neighbour : adjList.get(u)){
                int v = neighbour[0];
                int wt = neighbour[1];
                if(dist[v] > d + wt ) {
                    dist[v] = d + wt;
                    queue.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        for(int i = 0; i < V; i++) {
        if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
        
    }
}