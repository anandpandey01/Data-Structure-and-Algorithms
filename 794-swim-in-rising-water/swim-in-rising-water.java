class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int swimInWater(int[][] grid) {
        int m = grid.length;    int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited =  new boolean[m][n];
        pq.offer(new int[]{0,0,grid[0][0]});
        visited[0][0] = true;

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int r = node[0], c = node[1], maxLevelSoFar = node[2];
            if(r == m-1 && c == n-1) return Math.max(grid[r][c],maxLevelSoFar);
            for(int[] dir : directions){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if(visited[nr][nc] == true) continue;
                int max = Math.max(maxLevelSoFar, grid[nr][nc]);
                pq.offer(new int[]{nr, nc, max});
                visited[nr][nc] = true;
            }
        }
        return 0;
    }
}