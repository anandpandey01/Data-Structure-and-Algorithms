class Solution {
    int n;
    Integer[][][]dp;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        dp = new Integer[n][2][k+1];
        return solve(prices,0,1,k);        //1 Buy 0 Sell
    }
    public int solve(int[] prices,int i, int flag, int cap){
        if(i== n) return 0;
        if(cap ==0 ) return 0;
        if(dp[i][flag][cap] != null) return dp[i][flag][cap];
        if(flag==1){
            int buy =   -prices[i]+ solve(prices,i+1,0,cap);
            int notBuy = solve(prices,i+1,1,cap);
            dp[i][flag][cap] = Math.max(buy,notBuy);
        }
        else{
            int sell =    prices[i]+ solve(prices,i+1,1,cap-1);
            int notSell = solve(prices,i+1,0,cap);
            dp[i][flag][cap] = Math.max(sell,notSell);
        }
        return dp[i][flag][cap];
    }
}
