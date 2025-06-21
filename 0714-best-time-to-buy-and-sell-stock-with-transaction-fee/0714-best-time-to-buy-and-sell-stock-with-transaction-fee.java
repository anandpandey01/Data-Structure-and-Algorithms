class Solution {
    int n;
    int[][]dp;
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new int[n][2];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return solve(prices,0,1,fee);                       // flag 1 - Buy, 0 - Sell
    }
    public int solve(int[] prices, int i, int flag,int fee){    
        if(i==n) return 0;

        if(dp[i][flag]!= -1) return dp[i][flag];
        int profit=0;
        if(flag == 1){
            int buy =    -prices[i] + solve(prices, i+1, 0,fee);
            int notBuy =  solve(prices, i+1, 1,fee);
            profit = Math.max(buy,notBuy);
        }
        else{
            int sell =   prices[i]+ solve(prices, i+1, 1,fee)-fee;
            int notSell = solve(prices,i+1, 0,fee);
            profit = Math.max(sell,notSell);
        }
        return dp[i][flag] = profit;
    } 
}
