class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int size = adj.size();
        boolean visited [] = new boolean[size];
        queue.add(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            result.add(u);
            for(int v : adj.get(u)){
                if(visited[v]==false){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return result;
        
    }
}