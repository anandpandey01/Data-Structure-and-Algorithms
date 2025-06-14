class Solution {
    public int longestStrChain(String[] words) {
        int n= words.length;
        int[][]dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i],-1);
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        return solve(words,dp,n,-1,0);

    }
    public int solve(String[] words,int[][] dp, int n,int prevIndex,int i){
        if(i >=n ) return 0;
        if(dp[prevIndex+1][i]!= -1) return dp[prevIndex+1][i];
        int take = 0;
        if(prevIndex== -1 || isPredecessor(words[prevIndex],words[i])){
            take = 1+solve(words,dp,n,i,i+1);
        }
        int skip = solve(words,dp,n,prevIndex,i+1);
        dp[prevIndex+1][i] = Math.max(take,skip);
        return dp[prevIndex+1][i];
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