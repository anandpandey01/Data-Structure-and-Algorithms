// User function Template for Java

class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0; i<n; i++){
            hs.put(arr[i],i);
        }
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(Math.abs(hs.get(arr[i]) - i)>k) return "No";
        }
        return "Yes";
    }
}