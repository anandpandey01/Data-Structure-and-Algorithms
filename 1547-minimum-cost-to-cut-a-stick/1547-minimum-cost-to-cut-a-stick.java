class Solution {
    int[][]dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len = cuts.length;
        int[] newCuts = new int[len+2];
        int m = newCuts.length;
        newCuts[0] = 0;  newCuts[m-1] = n;
        for(int i=0; i<len; i++) newCuts[i+1] = cuts[i];
        dp = new int[m][m];
        for(int i=0; i<m; i++) Arrays.fill(dp[i],-1);
        return solve(newCuts,0,m-1);
    }
    public int solve(int[] newCuts,int i, int j){
        if(j-i< 2) return 0;                        //No Cut
        if(dp[i][j]!= -1) return dp[i][j];
        int result = Integer.MAX_VALUE;
        for(int k=i+1; k<=j-1;k++){
            int cost =  newCuts[j]-newCuts[i] + solve(newCuts,i,k)+solve(newCuts,k,j);
            result = Math.min(result,cost);
        }
        return dp[i][j]= result;
    }
}