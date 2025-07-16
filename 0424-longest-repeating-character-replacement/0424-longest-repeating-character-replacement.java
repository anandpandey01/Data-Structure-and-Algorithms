class Solution {
    public int characterReplacement(String s, int K) {
        int n = s.length();
        int[] count = new int[26];
        int i=0, j=0;

        int maxLength = 0,maxFrequency = 0;
        while(j < n){
            char ch = s.charAt(j);
            count[ch - 'A']++;
            maxFrequency = Math.max(maxFrequency, count[ch - 'A']);

            while((j-i+1) - maxFrequency > K){
                char ch1 = s.charAt(i);
                count[ch1 - 'A']--;
                maxFrequency = 0;
                for(int k=0; k<26; k++)  maxFrequency = Math.max(maxFrequency, count[k]);
                i++;
            }
            maxLength = Math.max(maxLength,j-i+1);      // if((j-i+1) - maxFrequency <= k)
            j++;
        }
        return maxLength;

    }
}

// No of changes i need to do is (n - maxfrequency) to change everything