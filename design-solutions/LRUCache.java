class LRUCache {

    int capacity;
    Map<Integer, Integer> mp;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new LinkedHashMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        if(!mp.containsKey(key))
            return -1;
        int val = mp.get(key);
        mp.remove(key);
        mp.put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key))
            mp.remove(key);
        else if(mp.size() == capacity){
            Map.Entry<Integer, Integer> entry = mp.entrySet().iterator().next();
            mp.remove(entry.getKey());
        }
        
        mp.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */