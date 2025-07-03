class Solution {
    List<String> result;

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<String>();

        result = new ArrayList<>();
        HashMap<Character,String> hs = new HashMap<>();
        hs.put('2',"abc");  hs.put('3',"def");  hs.put('4',"ghi");  
        hs.put('5',"jkl");  hs.put('6',"mno");  hs.put('7',"pqrs");
        hs.put('8',"tuv");  hs.put('9',"wxyz");  

        StringBuilder temp = new StringBuilder();
        solve(digits,0,hs,temp);
        return result;
    }
    public void solve(String digits,int idx, HashMap<Character,String> hs,StringBuilder temp){
        if(idx == digits.length()){
            result.add(temp.toString());
            return;
        }
        String str = hs.get(digits.charAt(idx));
        for(int i=0; i<str.length(); i++){
            temp.append(str.charAt(i));
            solve(digits,idx+1,hs,temp);        // Note idx+1 because now we want to take from other digit
            temp.deleteCharAt(temp.length()-1);
        }
    }
}