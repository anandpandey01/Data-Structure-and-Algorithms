class Solution {
    static int[][]dp;
    static int matrixMultiplication(int arr[]) {
        // code here
        int n =  arr.length;
        dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i],-1);
        return solve(arr,1,n-1);
        
    }
    public static int solve(int arr[], int i, int j){
        if(i>=j) return 0;
        if(dp[i][j]!= -1) return dp[i][j];
        int result = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int temp = solve(arr,i,k) + solve(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
            result = Math.min(result,temp);
        }
        return dp[i][j] = result;
    }
}