// User function Template for Java

class Solution {
    
    private int [][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        int[] parent = new int[rows*cols];
        for(int i=0; i<rows*cols; i++) parent[i] = i;
        int[] rank = new int[rows*cols];
        
        boolean[] visited = new boolean[rows * cols];
        List<Integer> result = new ArrayList<>();
        int count=0;
        
        for(int[] op : operators){
            int row = op[0]; int col = op[1];
            int index = row*cols+col;
            if(visited[index]){
                result.add(count);
                continue;
            }
            visited[index]=true;
            count++;
            for(int[] dir: directions){
                int nr = row+dir[0]; int nc = col+dir[1];
                int nIndex = nr*cols+nc;
                if(nr<0 || nr>=rows || nc<0 || nc>=cols) continue;    
                if(visited[nIndex] == false) continue; 
                if (union(parent, rank, index, nIndex)) {
                        count--;
                    }
            }
            result.add(count);
        }
        return result;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private boolean union(int[] parent, int[] rank, int x, int y) {
        
        int px = find(parent, x);
        int py = find(parent, y);
        if (px == py) return false;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
        return true;
    }
}