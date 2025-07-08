// User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        // code here
        int max=arr[0],sum = arr[0];
        for(int i=1; i<n; i++){
            max = Math.max(max,arr[i]);
            sum+=arr[i];
        }
        int low=max, high = sum;
        int ans = -1;
        while(low<=high){
            int minWeight = low+(high-low)/2;
            if(isPossible(arr,n,d,minWeight)){
                ans = minWeight;
                high = minWeight-1;
            }
            else{
               low = minWeight+1; 
            }
        }
        return ans;
        
    }
    static boolean isPossible(int[] arr, int n, int d, int minWeight){
        int sum=0,days =1;
        for(int i=0; i<n; i++){
            sum+=arr[i];
            if(sum>minWeight){
                sum = arr[i];
                days++;
            }
        }
        return (days<=d);
    }
};