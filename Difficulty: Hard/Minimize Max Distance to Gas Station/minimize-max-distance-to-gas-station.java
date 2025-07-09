// User function Template for Java

class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        double maxDifference = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            maxDifference = Math.max(maxDifference, stations[i+1]-stations[i]);
        }
        double low = 0; double high = maxDifference;
        double ans = high;
        
        while(high-low> 1e-6){                  // 2 decimal places
            double maxSectionLength = low+(high-low)/2;
            if(isPossible(stations,k,n,maxSectionLength)){
                high = maxSectionLength;
                ans = high;             // Note not maxDifference
            }
            else{
                low = maxSectionLength;
            }
        }
        return Math.round(ans * 100.0) / 100.0;
    }
    public static boolean isPossible(int stations[], int k,int n, double maxSectionLength){
    int count = 0;  
    for(int i=1; i<n;i++){
        double dist = stations[i] - stations[i - 1];
        double div = (dist / maxSectionLength);
        int numGasStations = (int)div;
         // If it is exact Division Reduce by 1
       if (div == numGasStations) {
            numGasStations--;
        }
        count+=numGasStations;
    }
        
     return (count<=k);  
    }
}
