class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lmax = height[0];
        int rMax = height[n-1];
        int i = 1, j = n-2;

        int result = 0;
        while(i <= j){
            lmax = Math.max(lmax, height[i]);
            rMax = Math.max(rMax, height[j]);
            if(lmax > rMax){
                result += rMax - height[j];
                j--;
            }
            else{
                result += lmax - height[i];
                i++;
            }
        }
        return result;

    }
}