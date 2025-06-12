class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int rows = flights.length;
        int cols = flights[0].length;
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int i=0; i<n; i++){
            adjList.put(i,new ArrayList<>());
        }
        for(int[] flight : flights){
            adjList.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }

        int []dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src,0});
        int steps =0;
        while(!queue.isEmpty() && steps<=k){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node= queue.poll();
                int u = node[0];
                int len = node[1];
                for(int[] neighbor : adjList.get(u)){
                    int v = neighbor[0], price = neighbor[1];
                    if(dist[v]>price+len){
                        dist[v] = price+len;
                        queue.offer(new int[]{v,dist[v]});
                    }
                    
                }
            }
            steps++;
        }
        return (dist[dst]== Integer.MAX_VALUE ? -1 : dist[dst]);
 
    }
}