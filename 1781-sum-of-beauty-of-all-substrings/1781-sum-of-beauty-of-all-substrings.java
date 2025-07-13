class Solution {
    public int beautySum(String s) {
        int n = s.length();

        int beauty = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE;  int max = Integer.MIN_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] != 0) { //  Note 0 means element itself is not present
                        min = Math.min(min, freq[k]);
                        max = Math.max(max, freq[k]);
                    }
                }
                beauty += (max - min);
            }
        }
        return beauty;
    }
}