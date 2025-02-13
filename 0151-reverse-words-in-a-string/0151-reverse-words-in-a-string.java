class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.trim().replaceAll("\\s+"," "));
        int len = sb.length();     
        reverse(sb,0,len-1);
        int start =0;
        for(int i=0;i<=len;i++){
            if(i==len || (sb.charAt(i) ==' ')){
                reverse(sb,start,i-1);
                start = i+1;
            }
        } 
        return sb.toString();
    }
    public void reverse(StringBuilder sb, int start, int end){
        while(start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp) ;
            start++;end--;
        }
    }
}