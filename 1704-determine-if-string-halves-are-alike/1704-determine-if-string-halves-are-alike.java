class Solution {
    public boolean halvesAreAlike(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int i=0, j=n/2;
        int countLeft = 0, countRight=0;
        while(i<n/2 && j<n){
            if(isVowel(s.charAt(i))){
               countLeft++; 
            }
            if(isVowel(s.charAt(j))){
               countRight++; 
            }
            i++; j++;
        }
        return (countLeft == countRight);
    }
    public boolean isVowel(Character ch){
        if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u') return true;
        if(ch == 'A' || ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U') return true;
        return false;
    }
}