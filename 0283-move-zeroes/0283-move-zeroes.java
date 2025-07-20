class Solution {
    public void moveZeroes(int[] arr) {
        int n=arr.length,i=0;
        for(int x: arr){
            if(x!=0)
                arr[i++] =x;
        }
        while(i<n){
            arr[i]=0;
            i++;
        }


    }
}