class Solution {
    public int longestStringChain(String words[]) {
        // code here
         Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
    HashMap<String, Integer> dp = new HashMap<>();
    int max = 1;

    for (String word : words) {
        int best = 0;
        for (int i = 0; i < word.length(); i++) {
            String prev = word.substring(0, i) + word.substring(i + 1);
            best = Math.max(best, dp.getOrDefault(prev, 0));
        }
        dp.put(word, best + 1);
        max = Math.max(max, best + 1);
    }
    return max;
    }
}
