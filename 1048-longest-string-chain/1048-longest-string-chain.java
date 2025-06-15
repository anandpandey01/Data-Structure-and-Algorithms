class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[]dp = new int[n+1];
        Arrays.fill(dp,1);
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        int maxLIS=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(isPredecessor(words[j],words[i])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxLIS = Math.max(maxLIS,dp[i]); 
                }
            }
        }
        return maxLIS;
    }
    public boolean isPredecessor(String prevWord, String currWord){
        int m = prevWord.length();  int n = currWord.length();
        if(n != m+1) return false;
        int i=0; int j=0;
        while(i<m && j<n){
            if(prevWord.charAt(i)== currWord.charAt(j)) i++;
            j++;
        }
        return i==m;

    }
}