// User function Template for Java

class Solution {    //Index of Smallest Element
    public int findKRotation(List<Integer> arr) {
        // Code here
        int n = arr.size();
        int low = 0, high = n-1;
        
        while(low<high){
            int mid= low+(high-low)/2;
            if(arr.get(mid)>arr.get(high)){
                low = mid+1;
            }
            else{
                high = mid;   //Probable Answer
            }
        }
        return high;
        
    }
}