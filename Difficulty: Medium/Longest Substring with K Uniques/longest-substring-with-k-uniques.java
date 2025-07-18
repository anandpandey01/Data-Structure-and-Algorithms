class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        HashMap<Character,Integer> hs = new HashMap<>();
        
        int i=0, j=0;
        int maxLength = 0;
        while(j < n){
            char ch = s.charAt(j);
            while(hs.size() > k){
                char ch1 = s.charAt(i);
                hs.put(ch1, hs.getOrDefault(ch1,0)-1);
                if(hs.get(ch1) == 0) hs.remove(ch1);
                i++;
            }
            
            hs.put(ch,hs.getOrDefault(ch,0)+1);
            if(hs.size() == k) maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        return (maxLength== 0) ? -1 : maxLength;
    }
}