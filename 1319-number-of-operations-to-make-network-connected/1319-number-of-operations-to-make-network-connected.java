class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) return -1;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)  parent[i] = i;
        int[] rank = new int[n];

        int wires = n;
        for (int[] edge : connections) {
            int u = edge[0]; int v = edge[1];
            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu != pv) { 
                union(parent, rank, pu, pv);
                wires--;     
            }
        }
        return wires-1;
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    static void union(int[] parent, int[] rank, int x, int y) {
        if (rank[x] > rank[y])
            parent[y] = x;
        else if (rank[y] > rank[x])
            parent[x] = y;
        else {
            parent[x] = y;
            rank[y]++;
        }
    }

}
