class Solution {
    int n;
    Integer[][][]dp;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        dp = new Integer[n+1][2][k+1];
        for(int flag=0; flag<=1; flag++){
            for(int cap=0;cap<=k;cap++){
                dp[n][flag][cap] = 0;
            }
        }
        for(int i=0; i<=n; i++){
            for(int flag=0; flag<=1; flag++){
                dp[i][flag][0] = 0;
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int cap=k; cap>0; cap--){

                int buy =   -prices[i]+ dp[i+1][0][cap];
                int notBuy = dp[i+1][1][cap];
                dp[i][1][cap] = Math.max(buy,notBuy);

                int sell =    prices[i]+ dp[i+1][1][cap-1]; 
                int notSell = dp[i+1][0][cap];  
                dp[i][0][cap] = Math.max(sell,notSell);

            }
        }
        return dp[0][1][k];        
    }
}
