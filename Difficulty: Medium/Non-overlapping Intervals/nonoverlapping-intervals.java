// User function Template for Java

class Solution {
    static int minRemoval(int arr[][]) {
        // code here
        int n= arr.length;
        Arrays.sort(arr, (a,b)-> Integer.compare(a[0],b[0]));
        int i=0, j=1;
        int count=0;
        while(j<n){
            int currStart = arr[i][0]; int currEnd = arr[i][1];
            int nextStart = arr[j][0]; int nextEnd = arr[j][1];
            if(nextStart>=currEnd){
                i=j; j++;               //Note not always the next have to be removed 
            }
            else{
                if(nextEnd>=currEnd){    // Without Equals sign TLE
                    j++;
                }
                else if(nextEnd<currEnd){
                   i = j;
                   j++; 
                }
                count++;
            }
        }
        return count;
    }
}
