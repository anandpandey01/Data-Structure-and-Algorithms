

//User function Template for Java

class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
            
        // Your code here
        if(n==0){
            return 0;
        }
        int pos=1;
        while(n>0 && (n&1)==0){
            pos++;
            n=n/2;
        }
       return pos; 
            
    }
}