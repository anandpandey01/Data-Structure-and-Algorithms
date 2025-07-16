class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        int i=0, j=0;
        int result = 0;

        while(j < n){
            while(hs.size() > 2){
                hs.put(fruits[i], hs.getOrDefault(fruits[i],0)-1);
                if (hs.get(fruits[i]) == 0) {
                    hs.remove(fruits[i]);
                }
                i++;
            }
            hs.put(fruits[j], hs.getOrDefault(fruits[j],0)+1);
            result = Math.max(result,j-i+1);
            j++;
        }
        return result;
    }
}