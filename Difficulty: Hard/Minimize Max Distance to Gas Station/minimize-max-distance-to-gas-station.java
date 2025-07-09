// User function Template for Java

class Solution {  // Brute Force
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        int[] inBetweenStation = new int[n-1];
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> {
            if(b[0]!=a[0]) return Double.compare(b[0],a[0]);
            return Integer.compare((int)b[1],(int)a[1]);
        });
        
        for(int i=0; i<n-1; i++){
            double difference = stations[i+1]-stations[i];
            pq.offer(new double[]{difference,i});
        }
        
        for(int gas=1; gas<=k; gas++){
            double[] value = pq.poll();
            double sectionLength = value[0]; int sectionIndex = (int) value[1];
            inBetweenStation[sectionIndex]++;
            double initialDifference = stations[sectionIndex+1]-stations[sectionIndex];
            double newSectionLength = initialDifference/(inBetweenStation[sectionIndex]+1);
            pq.offer(new double[]{newSectionLength,sectionIndex});
        }
        return pq.peek()[0];
        
    }
}
