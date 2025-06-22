class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        boolean[][]dp = new boolean[n+1][sum+1];
        // For i=0 (0 elements) from sum 1 to n is false - In Java by default
        for(int i=0; i<=n; i++){
            dp[i][0] = true;  // Sum 0 is possible for all i elements
        }
        for(int i=1; i<=n; i++){
            for(int j =1; j<=sum ; j++){
                boolean notPick = dp[i-1][j];
                boolean pick = false;
                if(arr[i-1]<=j){                 // i-1
                    pick = dp[i-1][j - arr[i-1]];
                }
                dp[i][j] = pick || notPick;
            }
        }
        return dp[n][sum];
    }
}



// dp[i][target] = true if we can form sum `target` using the first `i` elements
// (i.e., arr[0] to arr[i-1])
