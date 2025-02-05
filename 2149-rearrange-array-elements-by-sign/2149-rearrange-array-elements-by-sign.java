class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int arr1[] = new int[n/2];
        int arr2[] = new int[n/2];
        int a=0,b=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr1[a]=nums[i];
                a++;
                }
                else{
                    arr2[b]=nums[i];
                    b++;
                }
        }
        int c=0,d=0,k=0;
        while(k<n ){
            nums[k]=arr1[c];
            k++;c++;
            nums[k]=arr2[d];
            k++;d++;
        }
        return nums;
    }
}