class Solution {
    public int minSensors(int n, int m, int k) {
        int dist = (2*k + 1);
        int rows = (int) Math.ceil((n* 1.0)  / dist);
        int cols = (int) Math.ceil((m * 1.0) / dist);
        return rows * cols;
    }
}