class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.offer(new int[]{-1,0,0});  // parent current weight
        int mst = 0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int parent = node[0]; int curr = node[1]; int wt = node[2];
            if(visited[curr] == true) continue;
            visited[curr] = true;
            mst = mst+ wt;
            for(int[] v: adj.get(curr)){
                if(visited[v[0]]== false){
                    pq.offer(new int[]{curr,v[0],v[1]});
                }
            }
        }
        return mst;
    }
}