class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if(set.contains(beginWord)) set.remove(beginWord);

        int level=0;
        while(!queue.isEmpty()){
            int size= queue.size();
            while(size-- >0){
                String node = queue.poll();
                if(node.equals(endWord)) return level+1;
                List<String> neighbours = getNeighbours(node,set);
                for(String word : neighbours){    
                    queue.offer(word);
                    set.remove(word);
                }
            }
            level++;
        }
        return 0;
    }
    public List<String> getNeighbours(String word, HashSet<String> set){
        List<String> neighbour = new ArrayList<>();
        for(int i=0; i<word.length(); i++){
            for(char ch='a'; ch<='z';ch++){
                if(ch == word.charAt(i)) continue;
                String newWord = word.substring(0,i)+ch+word.substring(i+1,word.length());
                if(set.contains(newWord)) neighbour.add(newWord);
            }
        }
        return neighbour;
    }
}