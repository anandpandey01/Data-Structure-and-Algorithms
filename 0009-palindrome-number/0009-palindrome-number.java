class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i=0,n=str.length()-1;
        boolean flag=  false;
        while(i<=n){
            if(str.charAt(i)== str.charAt(n)){
                i++;n--;
                flag = true;
            }
            else{
                flag = false;
                break;
            }
        }
        if(flag==true){
            return true;
        }
    return false;
        
    }
}