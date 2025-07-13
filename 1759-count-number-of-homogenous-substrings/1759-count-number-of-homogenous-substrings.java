class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        int MOD = (int)1e9+7;
        int result = 0,len=0;
        for(int i=0; i<n; i++){
            if( i>0 && s.charAt(i)== s.charAt(i-1)){
                len+=1;
            }
            else{
                len = 1;
            }
            result= (result+ len)%MOD;
        }
        return result;
    }
}