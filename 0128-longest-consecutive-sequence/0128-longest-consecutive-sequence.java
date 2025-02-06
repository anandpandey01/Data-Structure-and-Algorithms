class Solution {
    public int longestConsecutive(int[] arr) {
        Arrays.sort(arr); int count=1;
        int res;
        if(arr.length ==0){
             res=0;
        }  else {
            res=1;
        }
        for(int i=0;i<arr.length-1;i++){
            if((arr[i+1] == arr[i]+1) ){
                count++;
                res = Math.max(res,count);
            }
            else if(arr[i+1] == arr[i])
                continue;
            else
                count=1;
        }
        return res;
    }
}