class Solution {
    public int fib(int n) {
       int prev = 0, curr =1;
       int sum = 0;
       if(n==1) return 1;
        while(n>1){
            sum = prev+ curr;
            prev = curr;
            curr = sum;
            n--;

        }
        return sum;
    }
}