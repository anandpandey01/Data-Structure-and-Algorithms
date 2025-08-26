class CheckBit {
    static boolean checkKthBit(int n, int k) {
        // code here
        int x = (1 << k);
        return ((n & x) != 0) ? true : false;
    }
}