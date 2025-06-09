class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        int[] rank = new int[n];

        int components=n;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    int parentI = find(parent, i);
                    int parentJ = find(parent, j);
                    if (parentI != parentJ) {
                        union(parent, rank, parentI, parentJ);
                        components--;
                    }
                }
            }
        }
        return n-components;
    }

    public int find(int[] parent, int x){
        if(parent[x] != x)  parent[x] = find(parent,parent[x]);
        return parent[x];
    }
    public void union(int[] parent, int[]rank ,int x, int y){
        if(rank[x]>rank[y]) parent[y] = x;
        else if (rank[x]<rank[y]) parent[x] = y;
        else{
            parent[x] = y;
            rank[y]++;
        }
    }
}