// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String beginWord,
                                                      String endWord,
                                                      String[] wordList) {
        // Code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(wordList));  // Note if its not List of String
        if (!set.contains(endWord)) return result;
        ArrayList<String> dummy = new ArrayList<>();
        dummy.add(beginWord);
        Queue<ArrayList<String>> queue = new LinkedList<>();
        queue.offer(dummy);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        int level = 0;  int resLevel = -1;
        while (!queue.isEmpty()) {
            HashSet<String> usedWords = new HashSet<>();
            int size = queue.size();
            while (size-- > 0) {
                ArrayList<String> nodeList = queue.poll();
                String node = nodeList.get(nodeList.size()-1);
                if (node.equals(endWord)){
                    resLevel = level;
                    result.add(nodeList);
                }     
                for (String neighbour : getNeighbours(node, set)) {
                    nodeList.add(neighbour);
                    queue.offer(new ArrayList<>(nodeList));
                    nodeList.remove(neighbour);
                    usedWords.add(neighbour);
                }
            }
            for(String visited : usedWords) set.remove(visited);
            if(level == resLevel) break;
            level++;
        }
        return result;
    }

    public ArrayList<String> getNeighbours(String word, HashSet<String> set) {
        ArrayList<String> neighbourList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (word.charAt(i) == ch)
                    continue;
                String newWord = word.substring(0, i) + ch + word.substring(i + 1, word.length());
                if (set.contains(newWord))
                    neighbourList.add(newWord);
            }
        }
        return neighbourList;
    }
    
}