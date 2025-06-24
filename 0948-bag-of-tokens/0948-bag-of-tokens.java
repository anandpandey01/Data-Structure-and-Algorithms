class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int score=0,maxScore=0;
        int i=0, j=n-1;
        while(i<=j){
            if(power>=tokens[i]){
                power = power-tokens[i];
                score++;
                i++;
                maxScore = Math.max(maxScore,score);
            }
            else if(score>=1){
                score--;
                power = power+tokens[j];
                j--;
            }
            else{
               break;
            }
        }
        return maxScore;
    }
}