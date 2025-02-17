class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hs1 = new HashMap<>();
        for(char ch : s.toCharArray()){
            hs1.put(ch,hs1.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> hs2 = new HashMap<>();
        for(char ch : t.toCharArray()){
            hs2.put(ch,hs2.getOrDefault(ch,0)+1);
        }
        if(hs1.equals(hs2)){
            return true;
        }
        return false;
    }
}