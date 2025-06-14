class Solution {
    public int findLongestChain(int[][] pairs) {
         int n= pairs.length;
        int[][]dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i],-1);
        Arrays.sort(pairs,(a,b)-> Integer.compare(a[1],b[1]));  // You can select pairs in any order.
        return solve(pairs,dp,n,0,-1);
    }
    public int solve(int[][]pairs, int[][]dp,int n,int i,int prevIndex){
        if(i>=n) return 0;
        if(dp[prevIndex+1][i]!= -1) return dp[prevIndex+1][i];

        int take=0;
        if(prevIndex == -1 || pairs[i][0]>pairs[prevIndex][1]){
            take = 1+solve(pairs,dp,n,i+1,i);
        }
        int skip = solve(pairs,dp,n,i+1,prevIndex);    // Note
        dp[prevIndex+1][i] = Math.max(take,skip);

        return dp[prevIndex+1][i];
    }
}
