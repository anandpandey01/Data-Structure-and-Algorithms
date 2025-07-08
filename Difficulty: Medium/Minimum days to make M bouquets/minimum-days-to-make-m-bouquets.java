// User function Template for Java

class Solution {
    public static int minDaysBloom(int m, int k, int[] bloomDay) {
        // code here
        int n = bloomDay.length;
        int min = bloomDay[0], max = bloomDay[0];
        for(int i=1; i<n; i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }
        int low = min, high = max;
        int ans = -1;
        while(low<=high){
            int minDays = low+(high-low)/2;
            if(isPossible(bloomDay,m,k,n,minDays)){
                ans =  minDays;
                high = minDays-1;
            }
            else{
                low = minDays+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] bloomDay, int m, int k, int n, int minDays){
        int count=0, noofbouquet = 0; ;
        for(int i=0; i<n; i++){
            if(minDays>=bloomDay[i]){
                count++;
            }
            else{
                count = 0;
            }
            if(count == k){
                noofbouquet++;
                count=0;
            } 
        }
        return (noofbouquet>=m);
    }
}
