// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n = arr.length;
        int i=0, j=0;
        
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while(j < n){
            sum+=arr[j];
            while(sum > x){
               minLength = Math.min(minLength, j-i+1);
               sum-=arr[i];
               i++;
            }
            j++;
        }
        return (minLength == Integer.MAX_VALUE)?0 : minLength;
    }
}
