class Solution {
    int n;
    int cols;

    public int cherryPickup(int[][] grid) {
        n = grid.length; cols= grid[0].length;
        int[][][] dp = new int[n + 1][cols + 1][cols + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= cols; j++) {
                for (int k = 0; k <= cols; k++)
                    dp[i][j][k] = -1;
            }
        }
        return solve(grid, dp, 0, 0, cols - 1); // i-row,j=col1,k=col2
    }

    public int solve(int[][] grid, int[][][] dp, int i, int j, int k) {
        if (j < 0 || j >= cols || k < 0 || k >= cols) return 0;
        if (i == n - 1) {
            if (j == k)
                return grid[i][j];
            return grid[i][j] + grid[i][k];
        }
        if (dp[i][j][k] != -1)
            return dp[i][j][k];

        int maxCherry = 0;
        for (int val1 = -1; val1 <= 1; val1++) {
            for (int val2 = -1; val2 <= 1; val2++) {
                int col1 = j + val1;
                int col2 = k + val2;
                maxCherry = Math.max(maxCherry, solve(grid, dp, i + 1, col1, col2));
            }
        }
        if (j == k)
            dp[i][j][k] = grid[i][j] + maxCherry;
        else
            dp[i][j][k] = grid[i][j] + grid[i][k] + maxCherry;

        return dp[i][j][k];
    }

}
