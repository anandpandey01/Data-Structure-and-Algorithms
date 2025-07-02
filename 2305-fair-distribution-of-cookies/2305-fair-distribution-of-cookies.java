class Solution {
    int n;
    int result = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        int[] children = new int[k];
        solve(cookies,k,children,0);
        return result;
    }
    public void solve(int[] cookies, int k,int[] children,int idx){
        if(idx >= n){
            int max = 0;
            for(int child: children){
                max = Math.max(max,child);
            }
            result = Math.min(result,max);
            return;
        }
        int cookie = cookies[idx];
        for(int i=0; i<k; i++){
            children[i] += cookie;
            solve(cookies,k,children,idx+1);
           children[i] -= cookie;

        }
    }
}