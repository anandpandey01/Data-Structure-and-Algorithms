class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3];
        int result = 0;
        int i=0, j=0;
        while(j < n){
            char ch = s.charAt(j);
            count[ch - 'a']++;
            while(allThree(count)){
                result = result + (n-j);
                count[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return result;

    }
    public boolean allThree(int[] count){
        for(int i=0; i<3; i++){
            if(count[i] == 0) return false;
        }
        return true;
    }
}