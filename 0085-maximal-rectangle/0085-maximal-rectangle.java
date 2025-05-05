class Solution {
    public int maximalRectangle(char[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[] heights = new int[c];
        int maxArea = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, calculateArea(heights, c));
        }
        return maxArea;
    }

    public int calculateArea(int arr[], int n) {
        int res = 0;
        int left[] = calculatePSE(arr, n);
        int right[] = calculateNSE(arr, n);
        for (int i = 0; i < n; i++) {

            int area = (right[i] - left[i] - 1) * arr[i];
            res = Math.max(res, area);
        }
        return res;
    }

    public int[] calculateNSE(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int nse[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] calculatePSE(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int pse[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}