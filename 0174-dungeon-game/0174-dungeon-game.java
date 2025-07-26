class Solution {
    int m;
    int n;
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;   n = dungeon[0].length;
        dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);

        return solve(dungeon,0,0);
    }
    public int solve(int[][] dungeon, int i, int j){
        if(i >=m  || j>=n)  return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == m-1 && j == n-1){
            if(dungeon[i][j] <= 0) return Math.abs(dungeon[i][j])+1;
            else return 1;
        }
        int down =  solve(dungeon, i+1, j);
        int right =  solve(dungeon, i, j+1);

        int result = Math.min(right, down) - dungeon[i][j];
        return dp[i][j] =  (result <= 0) ? 1 : result;

    }
}