class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();   //min Heap
        int i=0;
        while(i<n){
            if(pq.size()<k){
                pq.offer(nums[i]);
            }
            else if(pq.peek()<=nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
            i++;
        }
        return pq.peek();

    }
}