class Solution {
    int n;
    PriorityQueue<Integer> pq;
    public long maxScore(int[] nums1, int[] nums2, int k) {
        n = nums1.length;
        pq = new PriorityQueue<>();
        int sum=0,count=0,min = 0;
        return solve(nums1,nums2,k,sum,min,count,0);
    }
    public int solve(int[] nums1,int[] nums2,int k,int sum,int min,int count,int i){
        if(count == k){
            return sum*min;
        }
        if(i>=n) return 0;
        pq.offer(nums2[i]);
        int take =     solve(nums1,nums2,k,sum+nums1[i],pq.peek(),count+1,i+1);
        pq.remove(nums2[i]);
        int not_take = solve(nums1,nums2,k,sum,min,count,i+1);
        return Math.max(take,not_take);
    }
}