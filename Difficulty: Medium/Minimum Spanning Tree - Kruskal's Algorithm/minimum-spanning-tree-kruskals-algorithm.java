// User function Template for Java
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges , (a,b) -> Integer.compare(a[2],b[2]));
        int[] parent = new int[V];
        int[] rank =   new int[V];
        for(int i=0; i<V; i++)  parent[i] = i;
        
        int mst=0, totalEdge=0;
        for(int[] edge : edges){
            int u = edge[0]; int v = edge[1]; int wt = edge[2];
            int pu = find(parent,u);
            int pv = find(parent,v);
            
            if(pu!= pv){
                mst = mst+wt;
                union(parent,rank,pu,pv);
                totalEdge++;
                if(totalEdge == V-1) break;
            }
        }
        return mst;
    }
    
    static int find(int[] parent, int x){
        if(parent[x] != x)  parent[x] = find(parent,parent[x]);
        return parent[x];
    } 
    static void union(int[] parent,int[] rank, int x, int y){
        if(rank[x]>rank[y]) parent[y] = x;
        else if(rank[y]>rank[x]) parent[x] = y;
        else{
            parent[x] = y;   rank[y]++;
        }
    }
}
