class Solution {
    public int[] searchRange(int[] arr, int x) {
        int first=-1,last=-1;
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
               first=mid;
               high=mid-1;
              
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
            else if(arr[mid]<x){
                low=mid+1;
            }
        }
        low=0; high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                 last=mid;
                 low=mid+1;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
            else if(arr[mid]<x){
                low=mid+1;
            }
        }
        return new int[]{first,last};
    }
}