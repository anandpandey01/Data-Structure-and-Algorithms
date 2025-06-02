class Solution {
    int rows;
    int cols;
    public int[][] updateMatrix(int[][] mat) {
        rows = mat.length;
        cols = mat[0].length;
        int[][] dist = new int[rows][cols];

        for (int i = 0; i < rows; i++) {   // Initialize distances: 0 for zeros, -1 for ones
            for (int j = 0; j < cols; j++) {
                dist[i][j] = mat[i][j] == 0 ? 0 : -1;
            }
        }
        for (int i = 0; i < rows; i++) {       // Start DFS from all 0-cells
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dfs(mat, dist, i, j);
                }
            }
        }
        return dist;
    }

    public void dfs(int[][] mat, int[][] dist, int row, int col) {
        int[][] adjList = {{row - 1, col},  {row, col + 1}, {row + 1, col}, {row, col - 1}};

        for (int[] neighbour : adjList) {
            int r = neighbour[0];
            int c = neighbour[1];
            if (r < 0 || r >= rows || c < 0 || c >= cols) continue;
            // If not visited or a shorter distance is found
            if (dist[r][c] == -1 || dist[r][c] > dist[row][col] + 1) {
                dist[r][c] = dist[row][col] + 1;
                dfs(mat, dist, r, c);
            }
        }
    }
}