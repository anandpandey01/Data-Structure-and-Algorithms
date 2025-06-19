class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][]dp = new int[n+1][n+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return solve(triangle, dp, n, 0, 0);
    }
    public int solve(List<List<Integer>> triangle,int[][]dp,int n, int i, int j ){
        if(i== n-1) return triangle.get(i).get(j);
        if(dp[i][j]!= -1) return dp[i][j];
        int down =     triangle.get(i).get(j)+ solve(triangle, dp, n, i+1, j);
        int diagonal = triangle.get(i).get(j)+ solve(triangle, dp, n, i+1, j+1);
        dp[i][j] = Math.min(down,diagonal);
        return dp[i][j];

    }
}