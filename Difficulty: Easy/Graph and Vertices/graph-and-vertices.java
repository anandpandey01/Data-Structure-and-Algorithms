// User function Template for Java

class Solution {
    static long count(int n) {
        // code here
        long edges =  n*(n-1)/2;                // nC2
        return (long) Math.pow(2,edges);
    }
}
