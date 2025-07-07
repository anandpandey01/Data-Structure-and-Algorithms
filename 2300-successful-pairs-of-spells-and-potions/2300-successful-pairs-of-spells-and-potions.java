class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;  
        int[] result = new int[m];
        Arrays.sort(potions);
        for(int i=0; i<m; i++){
            int minPotions = (int)Math.ceil((double)success/spells[i]);
            result[i]= bSearchLowerBound(potions,minPotions);
        }
        return result;
    }
    public int bSearchLowerBound(int[]potions, int minPotions ){    // Lower Bound > or equals to
        int n = potions.length;
        int low=0, high= n-1; int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(potions[mid]>= minPotions){
                ans = mid;
                high = mid-1;
            }
            else if(potions[mid]< minPotions){
                low = mid+1;
            }
        }
        return (ans==-1)? 0: n-ans;  // Total number of Potions which will be >=success
    }
}