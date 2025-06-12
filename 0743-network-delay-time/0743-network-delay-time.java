class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){                         // Nodes labelled 1 to n
            adjList.add(new ArrayList<>());
        }
        for(int[] time : times){
            adjList.get(time[0]).add(new int[]{time[1],time[2]});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];  int timeSoFar = node[1];
            for(int[] neighbour : adjList.get(u)){
                int v= neighbour[0]; int wt = neighbour[1]; 
                if(dist[v]>dist[u]+wt){
                    dist[v]=dist[u]+wt;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
            int max = 0;
            for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
            }
        return max;
    }
}