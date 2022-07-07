// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Mathematics {
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//testcase
		int T=sc.nextInt();
		
		//looping testcase
		while(T-->0)
		{
		    Solution obj=new Solution();
		    int N;
		    
		    //number of elements in array
		    N=sc.nextInt();
		    int a[]=new int [N];
		    
		    //inseting elements in the array
		    for(int i=0;i<N;i++)
		    {
		        int x=sc.nextInt();
		        a[i]=x;
		    }
		    
		    //calling mean() and median() functions
		    System.out.println(obj.mean(a,N)+" "+obj.median(a,N));
		   
		    
		}
		
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
  //Function to find median of the array elements.  
  public int median(int A[],int N)
    {
      
       Arrays.sort(A);
       //If median is fraction then conver it to integer and return
       if(N%2!=0){
           return (A[(N-1)/2]);
       }
       else{
           return (int)Math.floor((A[N/2]+A[(N-1)/2])/2);   // Array indexing starts from zero
       }
       //Your code here
       //If median is fraction then conver it to integer and return
       
    }
    //Function to find median of the array elements.
    public int mean(int A[],int N)
    {
       //Your code here
       int sum=0;
       for(int i=0; i<N; i++){
          sum=sum+A[i]; 
       }
       return (int)(sum/N);
    }

}

