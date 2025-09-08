class Solution {
    public int[] getNoZeroIntegers(int n) {
        int start = 1, end = n-1;
        while(start <= end){
            if(noZero(start) && noZero(end)){
                return new int[]{start, end};
            }
            start++; end--;
        }
        return new int[]{};
    }
    public boolean noZero(int x){
        while(x > 0){
            int value = x % 10;
            if(value == 0) return false;
            x = x/10;
        }
        return true;
    }
}