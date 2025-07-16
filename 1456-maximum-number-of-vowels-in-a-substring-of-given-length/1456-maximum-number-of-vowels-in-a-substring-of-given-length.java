class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();

        int i=0, j=0;
        int count = 0, result = 0;
        while(j < n){
            if(isVowel(s.charAt(j))) count++;
            if(j-i+1 == k){
                result = Math.max(result, count);
                if(isVowel(s.charAt(i))) count--;
                i++;
            }
            j++;
        }
        return result;
    }
    public boolean isVowel(Character ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
}