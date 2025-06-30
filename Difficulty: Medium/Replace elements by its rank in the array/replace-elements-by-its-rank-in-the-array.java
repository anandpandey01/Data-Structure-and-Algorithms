// User function Template for Java

class Solution {
    static class Pair{
        int value;int index;
        Pair(int value,int index){
            this.value = value;
            this.index = index;
        }
    }
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.value,b.value));
        int[] rank = new int[N];
        for(int i=0; i<N; i++){
            pq.offer(new Pair(arr[i],i));
        }
        int rankSofar= 0;  int prevValue = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Pair curr = pq.poll(); int val = curr.value;  int i = curr.index;
            if(val!= prevValue){
                prevValue = val;
                rankSofar++;
            }
            rank[i] = rankSofar;
            
        }
        return rank;
        
    }
}
