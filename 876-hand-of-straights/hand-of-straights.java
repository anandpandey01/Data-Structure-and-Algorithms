class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0; i<n; i++){
            hs.put(hand[i], hs.getOrDefault(hand[i],0)+1);
        }
        Arrays.sort(hand);
       for(int card : hand){
            if (!hs.containsKey(card)) continue;
            int curr = card;
            for(int j=0; j<groupSize; j++){
                int num = curr+j;
                if(!hs.containsKey(num)){
                    return false;
                }
                hs.put(num, hs.get(num)-1);
                if(hs.get(num) == 0){
                    hs.remove(num);
                }   
            }

        }
        return true;
    }
}