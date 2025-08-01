class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if(set.contains(beginWord)) set.remove(beginWord);

        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String node  = queue.poll();
                if(node.equals(endWord)) return count+1;
                for(String neighbour : getNeighbour(node, set)){
                    queue.offer(neighbour);
                    set.remove(neighbour);
                }
            }
            count++;
        }
        return 0;
    }
    public List<String> getNeighbour(String word, HashSet<String> set){
        List<String> list = new ArrayList<>();
        for(int i=0; i<word.length(); i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                if(word.charAt(i) == ch) continue;
                String newWord = word.substring(0,i) + ch + word.substring(i+1);
                if(set.contains(newWord)) list.add(newWord);
            }
        }
        return list;
    }
}