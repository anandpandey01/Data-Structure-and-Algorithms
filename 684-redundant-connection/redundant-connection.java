class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];  
        for(int i=0; i<=n; i++) par[i] = i; 
        int[] rank = new int[n+1];

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            int pu = findParent(par, u);  int pv = findParent(par, v); 
            if(pu != pv){
                union(par, rank, u, v);
            }
            else{
                return new int[]{u,v};
            }
        }
        return new int[]{};
    }

    public int findParent(int[] par, int x){
        if(par[x] != x) par[x] = findParent(par , par[x]);
        return par[x];
    }

    public void union(int[] par, int[] rank, int x, int y){

        int px = findParent(par, x); 
        int py = findParent(par, y);

        if(px == py) return;
        if(rank[px] > rank[py]){
            par[py] = px;
        }
        else if(rank[px] < rank[py]){
            par[px] = py;
        }
        else{
            par[py] = px;
            rank[px]++;
        }


    }
}