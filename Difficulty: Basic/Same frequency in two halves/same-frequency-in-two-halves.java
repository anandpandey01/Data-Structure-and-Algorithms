// User function Template for Java

class Solution {
    boolean passed(String s) {
        // your code here
        int n = s.length();
        int i=0, j = 0;
        if(n%2 == 0) j = n/2;
        else j = n/2 +1;
        int[] freq1 = new int[26];  int[] freq2 = new int[26];
        
        while(i<n/2 && j<n){
            freq1[s.charAt(i)-'a']++;
            freq2[s.charAt(j)-'a']++;
            i++; j++;
        }
        return Arrays.equals(freq1,freq2);
        
    } 
    
}