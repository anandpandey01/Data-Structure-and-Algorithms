class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0,curr_min = prices[0];
        for(int i=1;i<prices.length;i++){
            curr_min = Math.min(curr_min,prices[i]);
            maxprofit=Math.max(maxprofit,prices[i]-curr_min);
            }
            return maxprofit;

    }
}