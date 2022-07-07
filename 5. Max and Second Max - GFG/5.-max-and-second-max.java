// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
        


// Solution class to implement function largestAndSecondLargest
class Solution{
    
    // Function to find largest and second largest element in the array
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[])
    {
        //code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        int largest= 0;
        for(int i=0;i<sizeOfArray;i++){
            if(arr[i]>arr[largest]){
                arr[largest] = arr[i];
            }  
        }
            list.add(arr[largest]);
        
        int index=-1;
        for(int i=0;i<sizeOfArray;i++){
            if(arr[i]!=arr[largest]){
                if(index==-1){
                    index=i;
                }
                else if(arr[i]>arr[index]){
                    index=i;
                }
            }
        }
        if(index==-1){
            list.add(-1);
        }
        else{
           list.add(arr[index]); 
        }
        
        return list;
     
     
     
     
     
        
    }
}

// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    int arr[] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int index = 0;index < sizeOfArray; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.largestAndSecondLargest(sizeOfArray, arr);
		    System.out.println(res.get(0) + " " + res.get(1) );
		}
	}
}  // } Driver Code Ends