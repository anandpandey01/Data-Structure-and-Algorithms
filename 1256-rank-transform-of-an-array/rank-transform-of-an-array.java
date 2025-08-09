class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copy = new int[n];
        for(int i=0; i<n; i++) copy[i] = arr[i];
        
        Arrays.sort(arr);
        int j = 1;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!hs.containsKey(arr[i])){
                hs.put(arr[i],j++);
            }
            
        }
        for(int i=0; i<n; i++){
            copy[i] = hs.get(copy[i]);
        }
        return copy;
    }
}