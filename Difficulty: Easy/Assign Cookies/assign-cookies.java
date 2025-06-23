
class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        // Your code goes here.
        Arrays.sort(greed);   Arrays.sort(cookie);
        int m = greed.length;   int n = cookie.length;
        int i=0,j=0;
        while(i<m && j<n){
            if(cookie[j]>=greed[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}