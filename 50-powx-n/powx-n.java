class Solution {
    public double myPow(double x, long n) {   // Changed it to long to avoid integer Overflow
        
        if(n == 0) return 1;
        if(n < 0) return myPow(1/x, -n);
        if(n % 2 == 0){
            return myPow(x*x, n/2);
        }
        return x * myPow(x*x, n/2);                    // Binary Exponentiation  
    }
}