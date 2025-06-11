/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        // add code here.
        if(par[x]!= x)  par[x] = find(par,par[x]);
        return par[x];
    }

    void unionSet(int par[], int x, int z) {
        // add code here.
        
        int[] rank = new int[par.length];
        
        int x_par = find(par,x);  int z_par = find(par,z);
        if(x_par == z_par) return;
        
        if(rank[x_par]> rank[z_par]){
            par[z_par] = x_par;
        }
        else if(rank[x_par]< rank[z_par]){
            par[x_par] = z_par;
        }
        else{
            par[x_par] = z_par;
            rank[z_par]++;
        }
    }
}