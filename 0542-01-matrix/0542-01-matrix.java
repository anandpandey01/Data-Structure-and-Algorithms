class Solution {   // Use a BFS and will traverse from 0 not 1
    int rows;
    int cols;
    public int[][] updateMatrix(int[][] mat) {
        rows = mat.length;
        cols = mat[0].length;
        int [][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    queue.offer(new int[]{i,j});
                }
                else{
                    dist[i][j]=-1;
                }
            }
        }
        int adjList[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for(int[] neigbour : adjList){
                int r = neigbour[0]+row;
                int c = neigbour[1]+col;
                if(r<0 || r>=rows || c<0 || c>=cols) continue;
                if(dist[r][c]!=-1) continue;
                dist[r][c] = dist[row][col]+1;
                queue.offer(new int[]{r,c});               
            }
        }
        return dist;

    }
}