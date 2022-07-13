// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        //testcases        
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //input string
            String st = sc.next();
            
            //calling powerSet() function
            ArrayList<String> ans = new LexSort().powerSet(st);
            
            //sorting the result of the powerSet() function
            Collections.sort(ans);
    
            //printing the result
            for(String s: ans)
                System.out.print(s + " ");
            System.out.println();    
        }
    }
}


 // } Driver Code Ends
//User function Template for Java


class LexSort
{
    //Function to return the lexicographically sorted power-set of the string.
    static ArrayList<String> powerSet(String s)
    {
        // add your code here
        ArrayList<String>list = new ArrayList<>();
        powerSet(s,"",0,list);
           Collections.sort(list);
            return list;
        
        
    }
    static void powerSet(String str,String curr,int index, ArrayList<String> list){
        if(str.length()==index){
            list.add(curr);
            return;
        }
        
        powerSet(str,curr,index+1,list);
        powerSet(str,curr+str.charAt(index),index+1,list);
    }
}


 

// { Driver Code Starts.

                                // } Driver Code Ends