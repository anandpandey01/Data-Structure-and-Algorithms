class Solution {
    public int reverse(int x) {
        long res = 0;
        int y = Math.abs(x);
        while(y>0){
            int lastdigit = y%10;
            res = res*10+ lastdigit;
            y/=10;
        }
        if(x<0) 
            res = -res;
        return ((res>Integer.MAX_VALUE)|| (res<Integer.MIN_VALUE))? 0: (int)res;
    }
}