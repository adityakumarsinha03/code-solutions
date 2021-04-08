class MyQueue {

    /** Initialize your data structure here. */
    
    Stack<Integer> st1;
    Stack<Integer> st2;
    
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!st2.isEmpty()){
            int y = st2.pop();
            st1.push(y);
        }
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!st1.isEmpty()){
            int x = st1.pop();
            st2.push(x);
        }
        if(!st2.isEmpty())
            return st2.pop();
        return -1;
    }
    
    /** Get the front element. */
    public int peek() {
        while(!st1.isEmpty()){
            int x = st1.pop();
            st2.push(x);
        }
        if(!st2.isEmpty())
            return st2.peek();
        return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(!st1.isEmpty() || !st2.isEmpty())
            return false;
        return true;
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