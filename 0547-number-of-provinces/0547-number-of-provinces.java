class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == false) {
                findCircleNum_helper(isConnected, visited, i);
                count++;
            }
        }
        return count;

    }

    public void findCircleNum_helper(int[][] isConnected, boolean visited[], int u) {
        visited[u] = true;
        for (int v = 0; v < isConnected.length; v++) {
            if (visited[v] == false && isConnected[u][v] == 1 ) {
                findCircleNum_helper(isConnected, visited, v);
            }
        }
    }
}
