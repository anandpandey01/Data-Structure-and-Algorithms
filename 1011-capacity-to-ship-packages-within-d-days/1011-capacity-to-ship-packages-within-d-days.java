class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n= weights.length;
        int sum =0, maxWeight = 0;;
        for(int i=0; i<n; i++){
            sum+=weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }
        int ans = -1;
        int low = maxWeight, high = sum;
        while(low<=high){
            int mid = low+(high-low)/2;
            int possibleDays = isPossible(weights,mid);
            if(possibleDays<=days){
                ans = mid;
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
    }
    public int isPossible(int[] weights,int minWeight){
        int m = weights.length;
        int currentLoad = 0;
        int day = 1;
        for(int i=0; i<m; i++){
            currentLoad+=weights[i];
            if(currentLoad > minWeight){
                day++;
                currentLoad = weights[i];
            }
        }
        return day;
    }
}