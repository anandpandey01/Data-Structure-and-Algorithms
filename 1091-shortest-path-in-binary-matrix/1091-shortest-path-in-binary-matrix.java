class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] != 0 || grid[rows - 1][cols - 1] != 0) return -1;

        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        int V = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0] = 1;
        int count=0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();           
            while(size-- >0){
                int[] node= queue.poll();
                int row = node[0];
                int col = node[1];
                if (row == rows - 1 && col == cols - 1) return count;
                for(int[] neighbours : directions){
                    int nr = row+ neighbours[0];
                    int nc = col+ neighbours[1];
                    if(nr<0 || nr>=rows || nc<0 || nc>=cols) continue;
                    if(grid[nr][nc]==0){
                        grid[nr][nc] = 1;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return -1;
    }
}