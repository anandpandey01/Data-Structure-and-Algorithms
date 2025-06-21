class Solution {
    int n;
    int[][]dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return solve(prices,0,1);                       // flag 1 - Buy, 0 - Sell
    }
    public int solve(int[] prices, int i, int flag){    
        if(i>=n) return 0;

        if(dp[i][flag]!= -1) return dp[i][flag];
        int profit=0;
        if(flag == 1){
            int buy =    -prices[i] + solve(prices, i+1, 0);
            int notBuy =  solve(prices, i+1, 1);
            profit = Math.max(buy,notBuy);
        }
        else{
            int sell =   prices[i]+ solve(prices, i+2, 1);
            int notSell = solve(prices,i+1, 0);
            profit = Math.max(sell,notSell);
        }
        return dp[i][flag] = profit;
    }
}
