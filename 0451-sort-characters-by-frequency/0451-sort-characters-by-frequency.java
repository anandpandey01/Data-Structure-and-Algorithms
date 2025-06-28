class Solution {
    class Frequency{
        char c; int count;
        Frequency(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
    public String frequencySort(String s) {
        int len = s.length();
        HashMap<Character,Integer> hs = new HashMap<>();
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);   
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Frequency> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.count,a.count));  // Max Heap
        for(Map.Entry<Character,Integer> entry: hs.entrySet()){
            pq.offer(new Frequency(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Frequency curr = pq.poll();
            while(curr.count>0){
                sb.append(curr.c);
                curr.count--;
            }
        }
        return sb.toString();

        
    }
}