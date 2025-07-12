class Solution {
    public int maxDepth(String s) {
        
        int result = 0;
        int count=0;
        for(char ch: s.toCharArray()){
            if(ch == '(') count++;
            result = Math.max(result,count);
            if(ch == ')') count--;
        }
        return result;
    }
}