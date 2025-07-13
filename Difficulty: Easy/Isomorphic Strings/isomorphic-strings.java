class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
         int n = s1.length();
        
        HashMap<Character, Character> hs1 = new HashMap<>();
        HashMap<Character, Character> hs2 = new HashMap<>();
        
        for(int i=0; i<n; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(hs1.containsKey(ch1) && hs1.get(ch1) != ch2) return false;
            if(hs2.containsKey(ch2) && hs2.get(ch2) != ch1) return false;
            
            hs1.put(ch1,ch2);
            hs2.put(ch2,ch1);
        }
        return true;
    }
    
    // Example - b a d c  || b a b a    // b maps to b then d is also mapped to b thats why hs2
}