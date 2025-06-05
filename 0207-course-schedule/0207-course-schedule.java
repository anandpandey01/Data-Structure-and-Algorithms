class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int V = numCourses;
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] neighbour : prerequisites){
            int u = neighbour[0];
            int v = neighbour[1];
            adjList.get(v).add(u);  // Note this
        }
        int[] indegree = new int[V];
        for(int u=0; u<V; u++){
            for(int v : adjList.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]== 0){
                queue.add(i);
            }   
        }
        int count=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int v: adjList.get(node)){
                indegree[v]--;
                if(indegree[v]==0){
                    queue.offer(v);
                }
            }
        }
        return(count==V);
    }
}