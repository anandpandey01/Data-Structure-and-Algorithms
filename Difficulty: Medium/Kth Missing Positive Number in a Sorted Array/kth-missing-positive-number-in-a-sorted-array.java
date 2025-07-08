class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int n = arr.length;
        int i=0, num=1;
        while(i<n){
            if(arr[i] == num){
                i++;
            }
            else{
                k--;
            }
            if(k == 0) return num;
            num++;
        }
        while(k-- >0){
            num++;
        }
        return num-1;
    }
}