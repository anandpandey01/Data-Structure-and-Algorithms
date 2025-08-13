// User function Template for Java

class Solution {
    static List<String> result;
    public static List<String> generateBinaryStrings(int n) {
        // code here
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0, n, sb, 0);    // prev is 0 means we can put 1 or 0  
        return result;
    }
    public static void solve(int i, int n, StringBuilder sb, int prev){
        if(i == n){
            result.add(sb.toString());
            return;
        }
        solve(i+1, n, sb.append("0"), 0);
        sb.deleteCharAt(sb.length() - 1);
        
        if(prev != 1){
            solve(i+1, n, sb.append("1"), 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    } 
}
