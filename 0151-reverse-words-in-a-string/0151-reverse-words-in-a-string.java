class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.trim().replaceAll("\\s+"," "));
        int n= sb.length();
        int start=0;
        reverse(sb,0,n-1);
        for (int end = 0; end <= n; end++) {
            if (end == n || sb.charAt(end) == ' ') {
                reverse(sb, start, end - 1);
                start = end + 1; // Move to the start of the next word
            }
        }
        return sb.toString();
    }
    private static void reverse(StringBuilder sb, int i, int j){
        while(i<j){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;j--;    
        }
    }

}