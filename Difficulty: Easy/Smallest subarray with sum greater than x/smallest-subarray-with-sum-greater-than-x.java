// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n = arr.length;
        int i=0, j=0;
        int prefixSum = 0, result = Integer.MAX_VALUE;
        
        while(j < n){
            prefixSum += arr[j];
            while(prefixSum > x){
                result = Math.min(result, j-i+1);
                prefixSum -= arr[i];
                i++;
            }
            j++;
        }
        return (result == Integer.MAX_VALUE)?0 : result;
        
    }
}
