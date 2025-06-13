// User function Template for Java

class Solution {

    public int towerOfHanoi(int n, int from, int to, int aux) {
        // Your code here
        if(n==0) return 0;
        if(n==1) return 1;  // Move rod (from - to)
        
        int x= towerOfHanoi(n-1,from,aux,to);  // Move from - aux for n-1 rods
        int y = 1;                             // Move from - to for 1 rod
        int z= towerOfHanoi(n-1,aux,to,from);  // Move aux - to for n-1 rod
        
        return x+y+z;
    }
}
