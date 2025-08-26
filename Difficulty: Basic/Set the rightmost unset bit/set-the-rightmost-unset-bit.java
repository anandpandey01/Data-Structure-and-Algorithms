// User function Template for Java
class Solution {
    static int setBit(int n) {
        // code here
        int k = 1;
        int value = n;
        while(n > 0){
            if((n & k)  == 0){
                n =  (n | k);
                return n;
            }
            k = k << 1;
        }
        return value;
        
    }
}