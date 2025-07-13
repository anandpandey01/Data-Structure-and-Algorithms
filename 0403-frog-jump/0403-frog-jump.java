class Solution {
    int n;
    HashMap<Integer, Integer> hs;
    public boolean canCross(int[] stones) {
        n = stones.length;
        if(stones[1] != 1) return false;
        Boolean[][] dp = new Boolean[n+1][n+1];
        hs = new HashMap<>();
        for(int i=0; i<n; i++) hs.put(stones[i],i);
        return solve(stones,dp,0,0);

    }
    public boolean solve(int[] stones,Boolean[][] dp,int i,int prevJump){
        if(i == n-1) return true;
        if(dp[i][prevJump]!= null) return dp[i][prevJump];
        boolean result = false;
        for(int nextJump = prevJump-1; nextJump<=prevJump+1; nextJump++ ){
            if(nextJump > 0){
                int next_stone = stones[i]+nextJump;
                if(hs.containsKey(next_stone)){
                    result = result || solve(stones,dp,hs.get(next_stone),nextJump);
                }
            }   
        }
        return dp[i][prevJump] =  result;
    }
}
