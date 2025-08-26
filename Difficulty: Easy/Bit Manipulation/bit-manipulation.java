// User function Template for Java

class Solution {
    static void bitManipulation(int num, int i) {
        // code here
        int x = (1 << (i-1));
        int get = ((num & x) != 0) ? 1 : 0;
        int set = (num | x);
        int clear = (num & ~(x));
        System.out.print(get + " " + set + " " + clear);
        
        
        
    }
}
