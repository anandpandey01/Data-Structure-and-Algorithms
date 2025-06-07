class Solution { //Dijkstra's
    // Can be solved by changing PQ to Queue because all distances are 1 its a unweighted graph
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] != 0 || grid[rows - 1][cols - 1] != 0)
            return -1;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        int V = grid.length;
        int[][] dist = new int[rows][cols];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] { 0, 0, 0 });
        grid[0][0] = 1;
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int row = node[0];
            int col = node[1];
            int dis = node[2];
            for (int[] neighbours : directions) {
                int nr = row + neighbours[0];
                int nc = col + neighbours[1];
                int wt = 1;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                    continue;
                if (grid[nr][nc] == 0) {
                    if (dist[nr][nc] > dis + wt) {
                        dist[nr][nc] = dis+ wt;
                        grid[nr][nc] = 1;
                        pq.offer(new int[] { nr, nc, dis + wt });
                    }
                }
            }

        }
        return dist[rows - 1][cols - 1] == Integer.MAX_VALUE ? -1 : dist[rows - 1][cols - 1] + 1;
    }
}