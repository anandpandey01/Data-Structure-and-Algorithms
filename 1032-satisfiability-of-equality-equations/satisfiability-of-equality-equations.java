class Solution {
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        int[] par = new int[26];  
        for(int i=0; i<26; i++) par[i] = i; 
        int[] rank = new int[26];
        
        List<int[]> notequalEdges = new ArrayList<>();
        for(String equation : equations){
            int u = equation.charAt(0) - 'a';
            int v = equation.charAt(3) - 'a';
            if(equation.charAt(1) == '='){
                union(par,rank, u, v);
            }
            else{
               notequalEdges.add(new int[]{u,v});
            }
        }
        for(int[] edge : notequalEdges){
            int u = edge[0], v = edge[1];
            if(findParent(par,u) == findParent(par,v)){
                return false;
            }
        }
        return true;
    }
    public int findParent(int[] par, int x){
        if(par[x] != x) par[x] = findParent(par , par[x]);
        return par[x];
    }

    public void union(int[] par, int[] rank, int x, int y){

        int px = findParent(par, x); 
        int py = findParent(par, y);

        if(px == py) return;
        if(rank[px] > rank[py]){
            par[py] = px;
        }
        else if(rank[px] < rank[py]){
            par[px] = py;
        }
        else{
            par[py] = px;
            rank[px]++;
        }


    }
}