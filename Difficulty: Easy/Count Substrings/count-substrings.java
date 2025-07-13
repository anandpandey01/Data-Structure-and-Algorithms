// User function Template for Java

class Solution {
    int countSubstr(String s) {
        // your code here
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') ones++;
        }
        return (ones * (ones-1))/2;  // Not include single
    }
}

//  total ones kC2 + k -- k is no of ones