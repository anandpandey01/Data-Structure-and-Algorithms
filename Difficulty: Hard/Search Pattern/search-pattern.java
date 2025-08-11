class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int m = txt.length();
        int n = pat.length();
        int[] lps = computeLPS(pat);
        
        int i = 0, j = 0;
        while(i < m){
            if(j < n && txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            if(j == n){
                result.add(i-j);
                j = lps[j-1];
            }
            else if(i < m && (j==0 || pat.charAt(j) != txt.charAt(i))){
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return result;
    }
    private int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;      // Length of the previous longest prefix suffix

        lps[0] = 0; // Because there is no proper suffix and prefix of pattern[0..0]

        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; //You can also write, len = len-1;
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}