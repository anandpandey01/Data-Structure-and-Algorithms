// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int n = txt.length(), m = pat.length();
        HashMap<Character, Integer> hs = new HashMap<>();
        for(char ch : pat.toCharArray()){
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        // Two Pointers
        int i=0, j=0;
        int count = 0;
        while(j<n){
            char ch = txt.charAt(j);
            if(hs.containsKey(ch)){
                hs.put(ch,hs.get(ch)-1);
            }
            int size = j-i+1;
            if(size == m){
                if(allZeros(hs)){
                    count++;
                }
                char ch1 = txt.charAt(i);
                if(hs.containsKey(ch1)){
                    hs.put(ch1,hs.get(ch1)+1);
                }
                i++;
            }
            j++;
        }
        return count;
    }
    public boolean allZeros(HashMap<Character, Integer> hs){
        
        for(int val : hs.values()){
            if(val != 0) return false;
        }
        return true;
    }
}