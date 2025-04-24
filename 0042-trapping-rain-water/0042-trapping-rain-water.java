class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int lmax[] = new int[n]; 
        int rmax[] = new int[n]; 
        lmax[0]=  arr[0]; rmax[n-1]=  arr[n-1]; 
        for(int i=1; i<n; i++){
            lmax[i] = Math.max(lmax[i-1],arr[i]);
        }
        for(int i=n-2; i>=0; i--){
            rmax[i] = Math.max(rmax[i+1],arr[i]);
        }
        int res =0;
        for(int k=0; k<n; k++){
             res = res+ Math.min(lmax[k],rmax[k])-arr[k];
        }
        return res;
        
    }
}