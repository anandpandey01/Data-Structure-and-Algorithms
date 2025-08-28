class Solution {
    public int minBitFlips(int start, int goal) {
        
        int xor = start ^ goal;
        int result = 0;
        while (xor > 0){
            if((xor & 1) == 1) result++;
            xor  = xor >> 1;
        }
        return result;
    }
}