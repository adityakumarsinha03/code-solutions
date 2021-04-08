class MyCircularQueue {

    Deque<Integer> dq;
    int cap;
    
    public MyCircularQueue(int k) {
        dq = new LinkedList<Integer>();
        cap = k;
    }
    
    public boolean enQueue(int value) {
        if(dq.size() < cap){
            dq.addLast(value);
            return true;
        } else
            return false;
    }
    
    public boolean deQueue() {
        if(!dq.isEmpty()){
            dq.removeFirst();
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(dq.size() > 0){
            return dq.getFirst();
        }
        return -1;
    }
    
    public int Rear() {
        if(dq.size() > 0){
            return dq.getLast();
        }
        return -1;
    }
    
    public boolean isEmpty() {
        if(dq.size() == 0){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(dq.size() == cap){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */