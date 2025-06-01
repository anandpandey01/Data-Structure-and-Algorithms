// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean visited[] = new boolean[adj.size()];
        int count=0;
        for(int i=0;i<V;i++){
            if(visited[i] == false){
                numProvinces_helper(adj,visited,i);
                count++;
            }
        }
        return count;
    }
    static void numProvinces_helper(ArrayList<ArrayList<Integer>> adj, boolean visited[],int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for (int v = 0; v < adj.get(u).size(); v++) {
                if(visited[v]==false && adj.get(u).get(v) == 1){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
   
};