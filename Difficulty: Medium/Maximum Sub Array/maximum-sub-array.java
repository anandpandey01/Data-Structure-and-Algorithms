// User function Template for Java

class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        int ansStart = -1, ansEnd = -1;
        int start = 0;
        
        for(int i=0; i<n; i++){
            if (arr[i] < 0) {
                currSum = 0;
                continue;
            }
            if(currSum == 0) start = i;
            currSum += arr[i];
            if(currSum > maxSum || (currSum == maxSum && (i - start) > (ansEnd - ansStart))){
                maxSum = currSum;
                ansStart = start;
                ansEnd = i;
            }
            //if(currSum < 0){
            //    currSum = 0;
            //}
        }
        if(ansStart != -1){
            for(int i=ansStart; i<=ansEnd; i++){
                result.add(arr[i]);
            }  
        }
        else {
            result.add(-1);
        }
        return result;
    }
}