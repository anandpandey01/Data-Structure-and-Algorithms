class Solution {
    int rows;
    int cols;
    public int[][] updateMatrix(int[][] mat) {
        rows = mat.length;
        cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Enqueue all 0s and mark as visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] adjList = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : adjList) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (visited[nr][nc]) continue;

                dist[nr][nc] = dist[r][c] + 1;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        return dist;
    }
}
