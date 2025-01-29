class Solution {
    public boolean isPalindrome(int x) {
        int ans = 0;
        int temp = x;
        while(temp>0){
            int lastdigit = temp%10;
            ans = ans*10+lastdigit;
            temp= temp/10;
        }
        return(x==ans);
        
    }
}