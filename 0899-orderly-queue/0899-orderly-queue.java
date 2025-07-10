class Solution {
    public String orderlyQueue(String s, int k) {
        if(k > 1){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            return sorted;
        }
        
        String result = s;
        for(int i=1; i<s.length(); i++){
            String rotated = s.substring(i) + s.substring(0, i);
            result = (rotated.compareTo(result)<0)?rotated:result;            
        }
        return result;
    }
}