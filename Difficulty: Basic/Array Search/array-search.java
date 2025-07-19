class Solution {
    static int search(int arr[], int x) {
        // code here
        int n = arr.length;
        int firstIndex = -1;
        for(int i=0; i<n; i++){
            if(arr[i] ==  x){
                firstIndex = i;
                break;
            }
        }
        return firstIndex;
    }
}
