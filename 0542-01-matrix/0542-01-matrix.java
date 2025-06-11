class Solution { // Doing BFS from 0 to 1 because its much more optimised than 1 to 0
    int rows;
    int cols;

    public int[][] updateMatrix(int[][] mat) {
        rows = mat.length;
        cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        int[][]adjList = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!queue.isEmpty()){
            int []cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for(int[] dir : adjList){
                int nr = row+dir[0]; int nc = col+dir[1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && dist[nr][nc]==-1){
                    dist[nr][nc] = dist[row][col]+1;
                    queue.offer(new int[]{nr,nc});
                }

            }
        }
        return dist;
    }
}