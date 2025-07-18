class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        int i=0, j=0;
        int result = 0;

        while(j < n){
            hs.put(fruits[j], hs.getOrDefault(fruits[j],0)+1);
            if(hs.size() > 2){
                int count = hs.get(fruits[i]) - 1;
                if(count == 0) {
                    hs.remove(fruits[i]);
                } else{
                    hs.put(fruits[i], count);
                }
                i++;
            }
            if(hs.size() <= 2){
                result = Math.max(result,j-i+1);   
            }
            j++;    
        }
        return result;
    }
}