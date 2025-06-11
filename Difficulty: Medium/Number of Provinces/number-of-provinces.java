// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] visited = new boolean[V];
        int count=0;
        for(int i=0; i<V; i++){
            if(visited[i]==false){
                bfs(adj,visited,V,i);
                count++;
            }
        }
        return count;
    }
    static void bfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int V,int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int v=0; v<adj.get(node).size(); v++){
                if(visited[v]==false && adj.get(node).get(v) == 1){
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
};