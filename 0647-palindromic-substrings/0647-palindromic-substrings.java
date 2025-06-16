class Solution { 
    public int countSubstrings(String s) {
        int n = s.length();
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
   
    public boolean isPalindrome(String s,int i,int j){
        if(i>j) return true;
        if(s.charAt(i) == s.charAt(j)) return isPalindrome(s,i+1,j-1);
        return false;       
    }
}