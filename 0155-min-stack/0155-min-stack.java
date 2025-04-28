class MinStack {
    Stack<Long> st;

    public MinStack() {
        st = new Stack<Long>();
    }
    long min;
    
    public void push(long val) {
        if(st.isEmpty()){
            st.push(val);
            min = val;
        }
        else if(val<=min){
            st.push(2*val-min);
            min = val;
        }
        else{
            st.push(val);
        }
    }
    
    public void pop() {
        long res = st.pop();
        if(res<=min){
            min = 2*min-res;
        }
           
    }
    
    public long top() {
        if (st.peek()<=min) return min;
        else return st.peek();
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */