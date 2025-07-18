class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i=0, index = 0;
        
        while(i<n){
            Character curr_char = chars[i];
            int count = 0;
            while(i<n && chars[i] == curr_char){
                count++;
                i++;
            }
            chars[index]= curr_char;
            index++;
            if(count>1){
                String count_str = count + ""; 
                for(char ch : count_str.toCharArray()){
                    chars[index] = ch;
                    index++;
                }
            }
        }
        return index;

    }
}