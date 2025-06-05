class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i< V; i++) adjList.add(new ArrayList<>());
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        int[] indegree = new int[V];
        for(int u=0; u<V; u++){
            for(int v : adjList.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0)  queue.offer(i);
        }
       int count=0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            count++;
            for(int v : adjList.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    queue.offer(v);
                }
            }
        }
        // Important Check if its not DAG 
        // if(result.size()!=V)
        return (count!=V);
        
    }
}