// User function Template for Java

class Solution {
    public int kthElement(int nums1[], int nums2[], int k) {
        // code here
        if(nums1.length > nums2.length){
            return kthElement(nums2,nums1,k);     // Use Shorter Array for Optimization
        }
        int m = nums1.length;   int n = nums2.length;

        int low = Math.max(0,k-n), high = Math.min(m,k);    //Note
        while(low<=high){
            int Px = low+(high-low)/2;    // Total Elements in Left Half from 1st Array
            int Py = k - Px;              // (m+n+1)/2 is total elements if divide in 2 parts Odd or Even

            int x1 = (Px==0)?Integer.MIN_VALUE: nums1[Px-1]; 
            int x2 = (Py==0)?Integer.MIN_VALUE:  nums2[Py-1];
            int x3 = (Px == m)?Integer.MAX_VALUE:nums1[Px];
            int x4 = (Py == n)?Integer.MAX_VALUE:nums2[Py];

            if(x4>=x1 && x3>=x2){
                return Math.max(x1,x2);
            }
            else if(x4<x1){
                high = Px-1;    
            }
            else if(x3<x2){
                low = Px+1;
            }
        }  
        return -1;  
    }
}
