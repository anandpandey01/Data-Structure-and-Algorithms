class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        int[] count = new int[26];
        for(int i=0; i<m; i++){
            count[pat.charAt(i)-'a']++;
        }
        // Two Pointers
        int i=0, j=0;
        List<Integer> result = new ArrayList<>();
        while(j<n){
            char ch = txt.charAt(j);
            count[ch-'a']--;
            int size = j-i+1;
            if(size == m){
                if(allZeros(count)){
                    result.add(i);
                }
                char ch1 = txt.charAt(i);
                count[ch1-'a']++;
                i++;
            }
            j++;
        }
        return result;
    }
    public boolean allZeros(int[] count){
        for(int val : count){
            if(val != 0) return false;
        }
        return true;
    }
}
