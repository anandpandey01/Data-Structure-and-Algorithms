class Solution {
    int n;
    int[][]dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return solve(prices,0,true);
    }
    public int solve(int[] prices, int i, boolean flag){    // flag 1 - Buy, 0 - Sell
        if(i==n) return 0;
        int f = (flag== true)?1:0;
        if(dp[i][f]!= -1) return dp[i][f];
        int profit=0;
        if(flag == true){
            int buy =    -prices[i] + solve(prices, i+1, !flag);
            int notBuy =  solve(prices, i+1, flag);
            profit = Math.max(buy,notBuy);
        }
        else{
            int sell =   prices[i]+ solve(prices, i+1, !flag);
            int notSell = solve(prices,i+1, flag);
            profit = Math.max(sell,notSell);
        }
        return dp[i][f] = profit;
    }
}