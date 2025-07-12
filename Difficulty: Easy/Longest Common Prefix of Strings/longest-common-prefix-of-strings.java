// User function Template for Java
class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        int n = arr.length;
        int len = arr[0].length();
        
        StringBuilder prefix = new StringBuilder();
        for(int i=0; i<len; i++){
            char ch1 = arr[0].charAt(i);
            for(int j=1; j<n; j++){
                char ch2 = arr[j].charAt(i);
                if( i== arr[j].length() || ch1 != ch2){
                    return prefix.toString();
                }
            }
            prefix.append(ch1);
        }
        return prefix.toString();
    }
}