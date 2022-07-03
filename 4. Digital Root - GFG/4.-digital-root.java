// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();//taking total testcases
        
        while(t-- > 0)
        {
            int n = sc.nextInt();//taking number n
            
            //calling digitalRoot() function of 
            //class Digital
            System.out.println(new Solution().digitalRoot(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int digitalRoot(int n) {
        // add your code here
        if (n == 0) {
            return 0;
        }
        n = digitalRoot(n / 10) + n % 10;

        if (n > 9) {
            int ans = 0;
            while (n > 0) {
                ans = ans + (n % 10);
                n = n / 10;
            }
            return ans;
        }

        return n;

    }
        
}