class Solution {   //Brute Force
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,  n = nums2.length;
        int[] result = new int[m+n];
        int i=0, j=0;
        int idx = 0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                result[idx++] = nums1[i];
                i++;         
            }
            else{
                result[idx++] = nums2[j];
                j++;
            }
        }
        while(i<m){
            result[idx++] = nums1[i]; 
            i++;
        }  
        while(j<n){
            result[idx++] = nums2[j];
            j++;
        }
        double ans = 0;
        int end = m+n;
        int mid = (0+end)/2;
        if(end%2 == 0){
            ans =  (result[mid-1]+result[mid])/2.0;     // Double
        }
        else{
            ans = result[mid];
        }
        return ans;
        
    }  
}