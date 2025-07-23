class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l < r){
            int mid = l+(r - l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    void merge(int arr[], int l, int mid, int r){
        int[] temp = new int[r-l+1];
        
        int i = l, j = mid+1, k=0;
        while(i <= mid && j <= r){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                k++; i++;
            }
            else{
                temp[k] = arr[j];
                k++; j++;
            }
        }
        while(i <= mid){
             temp[k] = arr[i];
              k++; i++;
        }
        while(j <= r){
            temp[k] = arr[j];
            k++; j++;
        }
        for(int t=0; t<temp.length; t++){
            arr[t+l] = temp[t];
        }
        
    }
}