class Solution {
    public String longestCommonPrefix(String[] str) {
        Arrays.sort(str);   // Sort lexicographically -  dictionary order
        int len = str.length-1;
        //for(int i=1;i<=len;i++){
           while(str[0].indexOf(str[len])!=0){
            str[len] = str[len].substring(0,str[len].length()-1);
           }
        //}
        return str[len];

    }
}