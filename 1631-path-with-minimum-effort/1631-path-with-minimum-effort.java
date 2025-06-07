class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for(int[]line : dist)  Arrays.fill(line,Integer.MAX_VALUE);
        int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,0});
        dist[0][0]=0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int row = node[0];
            int col = node[1];
            int effort = node[2];
            if (row == rows - 1 && col == cols - 1) return effort;
            for(int[] neighbour: directions){
                int r=neighbour[0] + row;
                int c=neighbour[1] + col;
                if(r<0 ||r>=rows || c<0 || c>=cols) continue;
                int currEffort = Math.max(effort,Math.abs(heights[r][c]-heights[row][col]));
                if(dist[r][c]>currEffort){
                    dist[r][c] = currEffort;
                    pq.offer(new int[]{r, c, currEffort});
                }
            }

        }
        return 0;
    }
}