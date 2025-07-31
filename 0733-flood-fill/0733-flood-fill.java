class Solution {
    int m;
    int n;
    int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int startColor = image[sr][sc];
        if (startColor == color) return image;  // If you wanna avoid below commented line
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r = node[0];  int c = node[1];
            for(int[] neighbour : dir){
                int nr = neighbour[0]+r;  int nc = neighbour[1]+c;
                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if(image[nr][nc] != startColor) continue;
                //if(image[nr][nc] == color) continue;
                queue.offer(new int[]{nr, nc});
                image[nr][nc] = color; 
            }
        }
        return image;
    }
}