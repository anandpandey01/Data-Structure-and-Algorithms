class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0, j=0;
        int m=0, n=0;
        while(m<word1.length && n<word2.length){
            if(word1[m].charAt(i) != word2[n].charAt(j)){
                return false;
            }
            i++; j++;
            if(i == word1[m].length()){
                i=0;
                m++;
            }
            if(j == word2[n].length()){
                j=0;
                n++;
            }
        }
        if(m == word1.length && n == word2.length) return true;
        return false;
    }
}