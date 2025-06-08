class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int) (1e9 + 7);
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adjList.get(road[0]).add(new int[] { road[1], road[2] });
            adjList.get(road[1]).add(new int[] { road[0], road[2] });
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            int u = (int) node[0];
            long curDist = node[1];

            if (curDist > dist[u])
                continue; // skip stale

            for (int[] neighbour : adjList.get(u)) {
                int v = neighbour[0];
                int wt = neighbour[1];
                long newDist = dist[u] + wt;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[] { v, newDist });
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}