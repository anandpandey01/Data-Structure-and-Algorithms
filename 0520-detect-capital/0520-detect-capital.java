class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int countCapitals = 0;
        for(char ch: word.toCharArray()){
            if(ch>='A' && ch<='Z') countCapitals++;
        }
        if(countCapitals == n) return true;
        if(countCapitals == 0) return true;
        if(word.charAt(0)>='A' && word.charAt(0)<='Z' && countCapitals == 1) return true;
        return false; 
    }
}