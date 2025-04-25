class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int a : arr) {
        boolean destroyed = false;

        while (!st.isEmpty() && a < 0 && st.peek() > 0) {
            if (st.peek() < -a) {
                st.pop();
                continue;
            } else if (st.peek() == -a) {
                st.pop();
            }
            destroyed = true;
            break;
        }

        if (!destroyed) {
            st.push(a);
        }
    }

    // Copy from bottom to top
    int[] res = new int[st.size()];
    for (int i = 0; i < st.size(); i++) {
        res[i] = st.get(i);
    }

    return res;
    }
}