class MyStack {

    /** Initialize your data structure here. */
    Deque<Integer> q;
    
    public MyStack() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!q.isEmpty())
            return q.pollLast();
        return -1;
    }
    
    /** Get the top element. */
    public int top() {
        if(!q.isEmpty())
            return q.peekLast();
        return -1;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(!q.isEmpty())
            return false;
        return true;
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