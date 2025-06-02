class Solution {                                           // BFS
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int count=0;
        for(int i=0; i<isConnected.length; i++){
            if(visited[i]==false){
                bfs(isConnected,visited,i);
                count++;
            }     
        }
        return count;

    }
    public void bfs(int[][] isConnected, boolean visited[],int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v=0; v<isConnected.length; v++){
                if(visited[v] == false && isConnected[u][v]==1){
                    queue.add(v);
                    visited[v]=true;                    
                }
            }
        }     
    }

}