class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if(t.length() > n) return "";
        HashMap<Character, Integer> hs = new HashMap<>();
        for(char ch : t.toCharArray()) hs.put(ch,hs.getOrDefault(ch,0)+1);
        int i=0, j=0;
        int minWindowSize = Integer.MAX_VALUE;    
        int requiredCount = t.length();   int start_i = 0;

        while(j<n){
            char ch = s.charAt(j);
            if (hs.containsKey(ch)) {
                if (hs.get(ch) > 0) requiredCount--;
                hs.put(ch, hs.get(ch) - 1);
            }        
            while(requiredCount == 0){
                int currWindowSize = j-i+1;
                if(currWindowSize < minWindowSize){
                    minWindowSize = currWindowSize;
                    start_i = i;
                }
                char ch1 = s.charAt(i);
                if (hs.containsKey(ch1)) {
                    hs.put(ch1, hs.get(ch1) + 1);
                    if (hs.get(ch1) > 0) requiredCount++;
                }
                i++;
            }
            j++;
        }
        return (minWindowSize == Integer.MAX_VALUE)? "": s.substring(start_i,start_i+minWindowSize);

    }
}