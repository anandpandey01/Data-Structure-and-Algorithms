class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String say = countAndSay(n-1);
        // Processing
        StringBuilder result = new StringBuilder();
        int i=0, len = say.length();
        while(i<len){
            Character current = say.charAt(i);
            int count = 0;
            while( i<len && say.charAt(i) == current){
                count++;
                i++;
            }
            result.append(count);
            result.append(current);
        }
        return result.toString();

    }
}