class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        HashMap<Character, Integer> hs = new HashMap<>();
        hs.put('M',1000); hs.put('D',500); hs.put('C',100); hs.put('L',50);
        hs.put('X',10); hs.put('V',5); hs.put('I',1);
        
        int ans = 0;
        for(int i=0; i<n; i++){
            int currValue = hs.get(s.charAt(i));
            if((i+1<n)  && currValue < hs.get(s.charAt(i+1))){
                ans-=currValue;     
            }
            else{
                ans+=currValue;            // To handle last character efficiently
            }
        }
        return ans;
    }
}