class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class MyHashMap {
    
    List<Pair> hashArr;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashArr = new ArrayList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = -1;
        for(int i = 0; i<hashArr.size(); i++){
            if(hashArr.get(i).x == key){
                index = i;
                break;
            }
        }
        if(index == -1)
            hashArr.add(new Pair(key, value));
        else
            hashArr.set(index, new Pair(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(int i = 0; i<hashArr.size(); i++){
            if(hashArr.get(i).x == key)
                return hashArr.get(i).y;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for(int i = 0; i<hashArr.size(); i++){
            if(hashArr.get(i).x == key){
                hashArr.remove(i);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */