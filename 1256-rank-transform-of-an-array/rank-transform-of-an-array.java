class Solution {
    class Pair{
        int val;
        int idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));
        for(int i=0; i<n; i++){
            pq.offer(new Pair(arr[i],i));
        }
        int rank = 0, prev = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int value = node.val, index = node.idx;
            if(value != prev){
                rank++;
                prev = value;
            }
            result[index] = rank;
        }
        return result;

    }
}