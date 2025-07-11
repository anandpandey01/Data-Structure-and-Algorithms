class Solution {
    public String countAndSay(int n) {
        // code here
        if(n == 1) return "1";
        String say = countAndSay(n-1);
        int i=0;
        int len = say.length();
        StringBuilder sb = new StringBuilder();
        while(i<len){
            int count = 0;
            Character last = say.charAt(i);
            while(i<len && last == say.charAt(i)){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(last);    
        }
        return sb.toString();
    }
}
