class Solution {
    int rows;
    int cols;
    int count = 0;

    public int numEnclaves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1)
                dfs(grid, i, 0);
            if (grid[i][cols - 1] == 1)
                dfs(grid, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1)
                dfs(grid, 0, j);
            if (grid[rows - 1][j] == 1)
                dfs(grid, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int row, int col) {
        int[][] adjList = { { row + 1, col }, { row - 1, col }, { row, col + 1 }, { row, col - 1 } };
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return;
        if (grid[row][col] != 1)
            return;

        grid[row][col] = 0;
        for (int[] neighbour : adjList) {
            dfs(grid, neighbour[0], neighbour[1]);
        }
    }
}
