class Solution {
    public boolean isPowerOfTwo(int n) {
        int i = 0, j = 32;
        while(i <= j){
            int mid = (i + (j-i)/2);
            if(Math.pow(2,mid) > n){
                j = mid-1;
            }
            else if(Math.pow(2,mid) < n){
                i = mid + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}