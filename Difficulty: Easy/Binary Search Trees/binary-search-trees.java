// User function Template for Java

class Solution {
    static boolean isBSTTraversal(int arr[]) {
        // code here
        int i=0;
        while(i<arr.length-1){
            if(arr[i+1]<=arr[i]){
                return false;
            }
            i++;
        }
        return true;
    }
}
