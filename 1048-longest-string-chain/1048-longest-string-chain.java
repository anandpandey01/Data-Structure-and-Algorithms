class Solution {
    public int longestStrChain(String[] words) {
        int n= words.length;
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(),b.length()));
        HashMap<String,Integer> map = new HashMap<>();
        int max=1;
        for(String word: words){
            int best=0;
            for(int i=0; i<word.length(); i++){
                String prevWord = word.substring(0,i)+word.substring(i+1,word.length());
                best = Math.max(best, map.getOrDefault(prevWord,0));
            }
            map.put(word,best+1);
            max = Math.max(max,best+1);
        }
        return max;
    }
}