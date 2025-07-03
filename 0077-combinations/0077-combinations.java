class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(1,n,k,temp);
        return result;
    }
    public void solve(int start, int n, int k, List<Integer> temp){
        if(k == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(start > n) return;

        temp.add(start);
        solve(start+1,n,k-1,temp);
        temp.remove(temp.size()-1);
        solve(start+1,n,k,temp);

    }
}