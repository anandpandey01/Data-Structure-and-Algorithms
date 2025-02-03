//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n1=a.length,n2=b.length;
        int first=0,second=0;
        Integer lastadded = null;
        while(first< n1 && second < n2){
            if(a[first]>b[second]){
                if(lastadded==null || lastadded!=b[second] ){
                   list.add(b[second]);
                   lastadded = b[second]; 
                }
                second++;
            }
            else if(a[first]<b[second]){
                if(lastadded==null || lastadded!=a[first] ){
                    list.add(a[first]);
                    lastadded = a[first]; 
                }
                    first++;
            }
            else{
                if(lastadded==null || lastadded!=a[first] ){
                    list.add(a[first]);
                    lastadded = a[first];
                }
                first++;
                second++;
            }
        }
        while(first<n1){
            if(lastadded==null || lastadded!=a[first] ){
                 list.add(a[first]); 
                 lastadded = a[first];
            }
            
            first++;
        }
        while(second<n2){
            if(lastadded==null || lastadded!=b[second] ){
                list.add(b[second]);
                lastadded = b[second];
            }
            
            second++;
        }
        
        return list;
    }
}
