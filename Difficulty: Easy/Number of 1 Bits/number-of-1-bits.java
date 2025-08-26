// User function Template for Java
class Solution { // Brian Kerringam Algorithm
    static int setBits(int n) {
        // code here
        int res = 0;
        while(n > 0){
            n = (n & (n-1));
            res++;
        }
        return res;
        
    }
}