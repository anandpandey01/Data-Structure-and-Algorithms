class Solution {
    ArrayList<String> result;
    int n;
    public ArrayList<String> findPermutation(String s) {
        // Code here
        n = s.length();
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        solve(sb,0);
        return result;
        
    }
    public void solve(StringBuilder sb, int idx){
        if(idx == n){
            result.add(sb.toString());
            return;
        }
        HashSet<Character> hs = new HashSet<>();
        for(int i=idx; i<n; i++){
            if(!hs.contains(sb.charAt(i))){
                swap(i,idx,sb);
                solve(sb,idx+1);
                swap(i,idx,sb); 
                hs.add(sb.charAt(i));
            }
            
        }
    }
    public void swap(int j, int k, StringBuilder str){
        char temp = str.charAt(j);
        str.setCharAt(j,str.charAt(k));
        str.setCharAt(k,temp);
        
    }
}