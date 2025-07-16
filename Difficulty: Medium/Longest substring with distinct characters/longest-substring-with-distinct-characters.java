// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        HashSet<Character> hs = new HashSet<>();
        int i=0, j=0;
        int result = 0;
        
        while(j < n){
            char ch = s.charAt(j);
            if(!hs.contains(ch)){
                hs.add(s.charAt(j));
                result = Math.max(result, j-i+1);   
            }
            else{
                while(hs.contains(ch)){
                    char ch1 = s.charAt(i);
                    hs.remove(ch1);
                    i++;  
                }
                hs.add(ch);      // Imp one of the duplicates needs to be added
            }
            j++;
        }
        return result;
    }
}