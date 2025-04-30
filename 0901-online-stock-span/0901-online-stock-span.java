class StockSpanner {
    Stack<Integer> st;
    List<Integer> prices = new ArrayList<>();
    int i = 0;
    public StockSpanner() {
        st = new Stack<>();

    }
    public int next(int price) {
        prices.add(price);
        while (!st.isEmpty() && price >= prices.get(st.peek())) {
            st.pop();
        }
        int span = st.isEmpty()?i+1:i-st.peek();
        st.push(i);
        i++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */