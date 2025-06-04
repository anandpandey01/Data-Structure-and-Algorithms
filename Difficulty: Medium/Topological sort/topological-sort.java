class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            //adjList.get(v).add(u);
        }
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>(); 
        boolean [] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(visited[i]==false)  dfs(adjList,visited,st,i);
        }
        
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
        
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adjList, boolean [] visited,
                                    Stack<Integer> st ,int u){
        visited[u] = true;
        
        for(int v:adjList.get(u)){
              if(visited[v]== false) dfs(adjList,visited,st,v);
        }
        st.push(u);
    }
    
}