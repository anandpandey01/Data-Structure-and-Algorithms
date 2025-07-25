class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        int i=0; int n = values.length;
        while(i<n){
            if(num == 0) break;
            while(num >= values[i]){
                num-=values[i];
                sb.append(roman[i]);
            }
            i++;
        }
        return sb.toString();
    }
}