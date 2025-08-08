class Solution {
    int m;
    int n;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        HashMap<Integer,Integer> hs = new HashMap<>();
        int uniqueId = 2;
        int maxArea = 0;
        for(int i= 0; i< m; i++){
            for(int j= 0; j< n; j++){
                if(grid[i][j] == 1){
                    int size = dfs(grid, i, j, uniqueId);
                    hs.put(uniqueId, size);
                    maxArea = Math.max(maxArea, size);
                    uniqueId++;
                }
            }
        }
        for(int i= 0; i< m; i++){
            for(int j= 0; j< n; j++){
                int area = 1;
                HashSet<Integer> usedKeys = new HashSet<>();
                if(grid[i][j] == 0){
                    for(int[] dir : directions){
                        int nr = dir[0]+i, nc = dir[1]+j;
                        if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                        int unique = grid[nr][nc];
                        if(hs.containsKey(unique)){
                            if(!usedKeys.contains(unique)){
                                area = area +  hs.get(unique);
                                usedKeys.add(unique);     
                            }             
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }    
            }
        }
        return maxArea;


    }
    public int dfs(int[][] grid, int i, int j, int uniqueId){
        if(i < 0 || i >= m || j < 0 || j >= n) return 0;
        if(grid[i][j] != 1) return 0;
        grid[i][j] = uniqueId;
        int count = 1;
        for(int[] dir : directions){
            int nr = dir[0]+i, nc = dir[1]+j;
            count += dfs(grid, nr, nc, uniqueId);
        }
        return count;
    }
}