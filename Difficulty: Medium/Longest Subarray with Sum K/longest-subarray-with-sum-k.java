//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        int prefixsum=0,count=0;
        for(int i=0;i<arr.length;i++){
            prefixsum = prefixsum + arr[i];
            if(prefixsum== k){
                count= Math.max(count, i+1);
            }
            else if(hs.containsKey(prefixsum-k)){
              count= Math.max(count,i-hs.get(prefixsum-k));
            }
            if (!hs.containsKey(prefixsum)) { 
                hs.put(prefixsum, i);
            }
        }
        return count;
    }
}
