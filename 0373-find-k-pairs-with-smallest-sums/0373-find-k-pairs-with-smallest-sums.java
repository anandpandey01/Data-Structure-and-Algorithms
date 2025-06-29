class Solution {    //Brute Force
    class Pair{
        int sum; int first; int second;
        Pair(int sum, int first, int second){
            this.sum = sum;
            this.first = first;
            this.second = second;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;  int n = nums2.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.sum,a.sum));   // Max Heap
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int smallestSum = nums1[i]+nums2[j];
                if(pq.size()<k){
                    pq.offer(new Pair(smallestSum,i,j));
                }
                else if(pq.peek().sum > smallestSum ){
                    pq.poll();
                    pq.offer(new Pair(smallestSum,i,j));
                }
                else{
                    break;                      // Because array is sorted
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(Arrays.asList(nums1[pq.peek().first], nums2[pq.peek().second]));
            pq.poll();
        }
        return result;
    }
}