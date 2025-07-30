// User function Template for Java//User function Template for Java
class Solution {

    int n;
    ArrayList<Integer> result;
    public ArrayList<Integer> subsetSums(int[] arr) {
        n = arr.length;
        result  = new ArrayList<>();
        int currentSum = 0;
        solve(arr, 0, 0);
        return result;
    }
    public void solve(int[] arr, int i,int currentSum){
        if(i == n){
            result.add(currentSum);
            return;
        } 
        solve(arr, i+1, currentSum+ arr[i]); 
        solve(arr, i+1, currentSum);

    }
    // Java passes primitives by value, currentSum + arr[i] creates a new value.
}