class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0; i<n; i++){
            hs.put(tasks[i],hs.getOrDefault(tasks[i],0)+1);
        }
        int count=0;
        for(int value : hs.values()){
            if(value == 1){
                return -1;
            }
            else if(value%3 ==0){                     //3K
                count = count+value/3;
            }
            else{                               // 3K+1 / 3K+2
                count = count+ (value/3)+1;
            }
        }
        return count;
        // for(Map.Entry<K,V> entry : hs.entrySet()){
        // for(int key : hs.keySet())
    }
}