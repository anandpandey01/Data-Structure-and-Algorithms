class Solution {
    public String longestCommonPrefix(String[] str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length-1;
        String lcp = str[0];
        for(int i=1;i<=len;i++){
           while(str[i].indexOf(lcp)!=0){
            lcp = lcp.substring(0,lcp.length()-1);
           }
        }
        return lcp;

    }
}