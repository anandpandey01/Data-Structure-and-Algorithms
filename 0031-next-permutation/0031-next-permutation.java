class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;
        int i=n-1;
        while(i>0 && arr[i-1]>=arr[i]){
            i--;    
        }
        if(i>0){
            int j=n-1;
             while (arr[j] <= arr[i - 1]) {
                j--;
            }
            int temp = arr[j];
             arr[j]= arr[i-1];
             arr[i-1]= temp;
        }
        Arrays.sort(arr,i,n);

    }
}