class MyStack {

    private Queue<Integer> mystack;
    public MyStack() {
        mystack= new ArrayDeque();
    }
    
    public void push(int x) {
        mystack.add(x);
         for (int i = 0; i < mystack.size() - 1; i++) {
            mystack.add(mystack.remove());
        }
    }
    
    public int pop() {
       return mystack.remove();
    }
    
    public int top() {
        return mystack.peek();
    }
    
    public boolean empty() {
        return (mystack.isEmpty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */