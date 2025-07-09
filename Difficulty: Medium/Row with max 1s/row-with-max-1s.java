// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int m = arr.length;  int n = arr[0].length;
        int maxCount = Integer.MIN_VALUE;
        int index = -1;
        
        for(int i=0; i<m; i++){
            int firstOccurence = findFirstOccurence1(arr[i]);
            int count = (firstOccurence == -1)?0 : n-firstOccurence;
            if(count>maxCount){
                maxCount = count;
                index = i;
            }
        }
        return index;
    }
    public int findFirstOccurence1(int[] arr){
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == 1){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}