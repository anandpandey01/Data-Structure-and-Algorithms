// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int n= arr.length;
        int[][]dp = new int[n+1][4];  // 0,1,2 // 3- first day can do any of three
        for(int i=0; i<=n; i++) Arrays.fill(dp[i],-1);
        return solve(arr,dp,0,3,n);     
    }
    public int solve(int[][]arr,int[][]dp, int i,int prev,int n){
        if(i>=n)  return 0;
        if(dp[i][prev]!= -1) return dp[i][prev];
        int maxValue=0;
        for(int j=0; j<3; j++){
            if(j!= prev){
                int points = arr[i][j]+solve(arr,dp,i+1,j,n);
                maxValue = Math.max(maxValue,points);
            }
        }
        return dp[i][prev] = maxValue;
    }
    
}