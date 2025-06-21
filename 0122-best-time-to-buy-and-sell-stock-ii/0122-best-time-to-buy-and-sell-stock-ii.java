class Solution {
    int n;
    int[][]dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n+1][2];               // 1 - Buy, 0 - Sell
        dp[n][1] = 0;   dp[n][0] = 0;
        for(int i=n-1; i>=0; i--){
            for(int flag=0; flag<=1; flag++){
                if(flag == 1){
                    int buy =    -prices[i] + dp[i+1][0];
                    int notBuy =  dp[i+1][1];
                    dp[i][1] = Math.max(buy,notBuy);
                }
                else{
                    int sell =  prices[i] + dp[i+1][1];
                    int notSell = dp[i+1][0];
                    dp[i][0] = Math.max(sell,notSell);
                }
            }
        }
        return dp[0][1];
    }
}