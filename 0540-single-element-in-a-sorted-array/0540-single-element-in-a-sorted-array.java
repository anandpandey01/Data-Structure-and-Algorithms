class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int low = 0, high = n-1;
        while(low<high){     //Note
            int mid = low+(high-low)/2;
            if(arr[mid]!= arr[mid+1]){
                int count = high-mid;
                if(count%2 != 0){   // Odd elements on the right
                    low = mid+1;
                }
                else{
                    high = mid;   //Note
                }
            }
            else if(arr[mid]== arr[mid+1]){
                int count = high-mid;
                if(count%2 != 0){
                    high = mid-1;
                }
                else{
                    low = mid+2;    //Note
                }
            }
        }
        return arr[high];
    }
}