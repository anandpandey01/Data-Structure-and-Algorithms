class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low=1;
        int high=piles[0];
        for(int i=1; i<n; i++){
            high = Math.max(high,piles[i]);
        }
        while(low<high){
            int mid = low+(high-low)/2;
            int hour=0;
            for(int pile: piles){
                hour+=Math.ceil((double)pile/mid);
            }
            if(hour > h){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return high;

    }
}