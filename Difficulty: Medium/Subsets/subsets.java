// User function Template for Java

class Solution {
    ArrayList<ArrayList<Integer>> result;
    int n;
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        Arrays.sort(arr);   // For Lexiographic - Dictionary
        result = new ArrayList<>();
        n= arr.length;
        List<Integer> temp = new ArrayList<>();
        solve(arr,0,temp);
        return result;
        
    }
    public void solve(int arr[],int i,List<Integer> temp){

        result.add(new ArrayList<>(temp));
        for(int j=i; j<n; j++){
            temp.add(arr[j]);
            solve(arr,j+1,temp);
            temp.remove(temp.size()-1); 
        }
    }
}