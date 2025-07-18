class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lSum = 0, rSum = 0, maxSum = 0;
        for(int i=0; i<k; i++) lSum += cardPoints[i];
        maxSum = lSum;

        int j = n-1;
        for(int x=k-1; x>=0; x--){
           lSum -=cardPoints[x];
           rSum +=cardPoints[j];
           maxSum = Math.max(maxSum,lSum+rSum);
           j--;
        }
        return maxSum;
    }
}