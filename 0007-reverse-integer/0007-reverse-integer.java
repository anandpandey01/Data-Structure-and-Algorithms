class Solution {
    public int reverse(int x) {
        int absx= Math.abs(x);
        long ans = 0;
        while(absx>0){
            int lastdigit = absx%10;
            ans = ans*10+lastdigit;
            absx=absx/10;
        }
        if(x<0){
            ans = -ans;
        }
        return ((ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE)?0 : (int) ans);
             
    }
}