// User function template for JAVA

class Solution {
    // Function to check if a string is Pangram or not.
    public static boolean checkPangram(String sentence) {
        // your code here
        int[] arr = new int[26];
        for(char ch: sentence.toCharArray()){
            if (Character.isLetter(ch)) {
                char c = Character.toLowerCase(ch);
                arr[c-'a']++; 
            }
        }
        for(int i=0; i<26; i++){
            if(arr[i] == 0) return false;
        }
        return true;
    }
}