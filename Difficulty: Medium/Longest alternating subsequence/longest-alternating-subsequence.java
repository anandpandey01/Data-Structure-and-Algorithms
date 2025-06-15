// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    public int alternatingMaxLength(int[] arr) {
        // code here
        int n= arr.length;
        int increasing = 1;
        int decreasing = 1;
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1])  increasing = decreasing+1;
            else if(arr[i]<arr[i-1]) decreasing = increasing+1;
            
        }
        return Math.max(increasing,decreasing);
    }
}