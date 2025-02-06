class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;
        for(int i=n-1;i>0;i--){
            if(arr[i-1]<arr[i]){
                int temp=arr[i];
                arr[i]= arr[i-1];
                arr[i-1]= temp;
                break;
            }
            else{
                Arrays.sort(arr);
                break;
            }
        }
    }
}