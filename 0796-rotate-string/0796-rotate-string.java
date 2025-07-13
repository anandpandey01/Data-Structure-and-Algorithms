class Solution {
    public boolean rotateString(String s, String goal) {
        int start=0;
        StringBuilder sb = new StringBuilder(s);
        while( sb.length()>start){
            if (sb.toString().equals(goal)) {  // Check if the current rotation matches the goal
            return true;
        }
            char first= sb.charAt(0);
            sb.deleteCharAt(0); 
            sb.append(first);  
            start++;
        }
        
        return false;

    }
}