class Solution {
    public int findNumbers(int[] nums) {
        

        int count=0;
        for(int a:nums){
            if (even(a)){
                count++;
            }
        }
        return count;
    }

     public boolean even(int a) {
         if(a==0){
            return false;
        }
        int count=0;
        while (a>0){
            count++;
            a = a/10;
        }
        return count % 2 == 0;
    }
    
}