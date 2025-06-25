// User function Template for Java

class Solution {
    static List<Integer> minPartition(int N) {
        // code here
        int[] coins = {2000,500,200,100,50,20,10,5,2,1};
        List<Integer> result = new ArrayList<>();
        
        while(N!=0){
            for(int coin: coins){
                if(N>=coin){
                    int count = N/coin;
                    for (int i = 0; i < count; i++) {
                        result.add(coin);
                    }
                    N -= coin * count;
                    break; 
                }
            }
        }
        return result;
    }
}