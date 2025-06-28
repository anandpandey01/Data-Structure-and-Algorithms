class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0; i<n; i++){
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[1],a[1]));
        for( Map.Entry<Integer, Integer> entry : hs.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        int [] result = new int[k];
        for(int i=0; i<k; i++){
            int[] curr = pq.poll();
            result[i] = curr[0];
        }
        return result;

    }
}