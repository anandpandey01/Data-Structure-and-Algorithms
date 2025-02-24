class MyQueue {

    ArrayDeque<Integer> myQueue;
    public MyQueue() {
        myQueue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        myQueue.addFirst(x);
    }
    
    public int pop() {
        return myQueue.removeLast();
    }
    
    public int peek() {
        return myQueue.peekLast();
    }
    
    public boolean empty() {
        return myQueue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */