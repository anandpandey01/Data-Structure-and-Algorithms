class Solution {
    int[][] serves = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
    private double[][] t;
    
    public double soupServings(int n) {
        if (n >= 5000)
            return 1.0;
        t = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(t[i], -1.0);
        }
        return solve(n, n);
    }
     private double solve(int A, int B) {
        if (A <= 0 && B <= 0)   return 0.5;
        if (A <= 0)             return 1.0;
        if (B <= 0)             return 0.0;

        if (t[A][B] != -1.0)   return t[A][B];

        double probability = 0.0;
        for (int[] p : serves) {
            int A_serve = p[0];
            int B_serve = p[1];
            probability += 0.25 * solve(A - A_serve, B - B_serve);
        }
        return t[A][B] = probability;
    }
}
