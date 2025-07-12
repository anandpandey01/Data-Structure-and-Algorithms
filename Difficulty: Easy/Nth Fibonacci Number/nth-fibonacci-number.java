// User function Template for Java

class Solution {   // Normal Approach
    public int nthFibonacci(int n) {
        // code here
        if(n==0 || n==1) return n;
        int a =0, b = 1;
        for(int i=2; i<=n; i++){
            int c = b+a;
            a = b;
            b = c;
        }
        return b;
    }
}