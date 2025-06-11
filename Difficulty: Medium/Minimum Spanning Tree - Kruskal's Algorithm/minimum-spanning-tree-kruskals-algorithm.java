// User function Template for Java
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        int[] par = new int[V];
        for(int i=0; i<V; i++) par[i] = i;
        int[] rank = new int[V];
        Arrays.sort(edges,(a,b) -> Integer.compare(a[2],b[2]));
        
        int mst=0; //totaledges=0;
        for(int[] edge : edges){
            int u =edge[0]; int v = edge[1]; int wt = edge[2];
            
            int u_par = find(par,u); int v_par = find(par,v);
            if(u_par != v_par){
                mst= mst+wt;
                union(par, rank,u_par,v_par);
                //totaledges++;
                //if(totaledges == V-1) break;
            }
        }
        return mst;
    }
    static int find(int[] par, int x){
        if(par[x]!=x) par[x] = find(par, par[x]);
        return par[x];
    }
    static void union(int[] par, int[] rank, int x, int y){
        int x_par = find(par, x);
        int y_par = find(par,y);
        if(x_par == y_par) return;
        
        if(rank[x_par]>rank[y_par]){
            par[y_par] = x_par;
        }
        else if(rank[x_par]<rank[y_par]){
            par[x_par] = y_par;
        }
        else{
            par[x_par] = y_par;
            rank[y_par]++;
        }
    }
}
