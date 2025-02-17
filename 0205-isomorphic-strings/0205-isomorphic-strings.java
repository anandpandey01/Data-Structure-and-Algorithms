class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hs = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hs.containsKey(s.charAt(i))){
                if(!hs.containsValue(t.charAt(i))){
                hs.put(s.charAt(i),t.charAt(i));
                }
                else{
                    return false;
                }
            }
            else{
               if(hs.get(s.charAt(i)) != t.charAt(i)){
                    return false;
               }        
            }  
        }
        return true;


    }
}