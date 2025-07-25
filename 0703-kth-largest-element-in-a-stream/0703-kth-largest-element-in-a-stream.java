class KthLargest {
    private PriorityQueue<Integer> minheap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minheap = new PriorityQueue<>();
        this.k = k;
        for(int num: nums){                                 // Its a stream of data
            minheap.offer(num);
            if(minheap.size() > k) minheap.poll();
        }
    }
    
    public int add(int val) {
        minheap.offer(val);
        if(minheap.size()> k){
            minheap.poll();
        }
        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */