class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int max = bloomDay[0];
        for(int i=1; i<n; i++){
            max = Math.max(max,bloomDay[i]);
        }
        int low=0, high=max;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canBloom(bloomDay,k,mid)>=m){
                ans = mid;
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int canBloom(int[] bloomDay,int k,int days){
        int m = bloomDay.length;
        int consecutiveCount=0,totalbouquets = 0;
        for(int i=0; i<m; i++){
            if(days>=bloomDay[i]){
                consecutiveCount++;
            }
            else{
                consecutiveCount = 0;
            }
            if(consecutiveCount == k){
                totalbouquets++;
                consecutiveCount = 0;
            }
        }
        return totalbouquets;
    }
}