class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if(n>0){
            while(n>0){
                res=res*x;
                n--;
            }
        }
        else{
            int abs = Math.abs(n);
            while(abs>0){
                res=res/x;
                abs--;
            }
        }
        return res;
    }
}