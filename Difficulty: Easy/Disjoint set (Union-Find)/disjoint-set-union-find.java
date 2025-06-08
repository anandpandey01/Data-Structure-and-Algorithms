/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
      // add code here
    if (par[x] == x){
        return x;
    }
    return find(par, par[x]);
}

void unionSet(int par[], int x, int z) {
    // add code here.
    
    int x_parent = find(par, par[x]);
    int z_parent = find(par, par[z]);
    if (x_parent != z_parent){
        par[x_parent] = z_parent;
    }
}
}