class LFUCache {

    int capacity;
    
    // CacheMap to store <Key, Page>
    Map<Integer, Page> cacheMap;
    
    // FreqMap to store <Freq, Map<Key, Page> >
    Map<Integer, LinkedHashMap<Integer, Page> > freqMap;
    
    int minFreq = Integer.MAX_VALUE;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        Page page = cacheMap.get(key);
        if(page == null)
            return -1;
        updatePage(page);
        return page.val;
    }
    
    public void put(int key, int value) {
        if(capacity <= 0)
            return;
        Page page = cacheMap.get(key);
        if(page == null)
            page = new Page(key, value, 0);
        page.val = value;
        updatePage(page);
    }
    
    public void updatePage(Page page){
        int freq = page.freq;
        page.freq = page.freq + 1;
        
        // New node
        if(freq == 0){
            // Cache size is full
            if(cacheMap.size() == capacity){
                // Extract LinkedHashMap of freq from freqMap
                Map<Integer, Page> mp = freqMap.get(minFreq);
                
                // Remove the first entry (LRU) from extracted map
                Map.Entry<Integer, Page> entry = mp.entrySet().iterator().next();
                mp.remove(entry.getKey());
                
                // Remove it from cacheMap
                cacheMap.remove(entry.getKey());
                
                // If extracted map becomes empty, delete the key from freqMap
                if(mp.isEmpty())
                    freqMap.remove(minFreq);
            }
            // Update minFreq to 1, due to addition of new node
            minFreq = 1;
            
            // add the new node to cacheMap
            cacheMap.put(page.key, page);
        } else{
            // Extract LinkedHashMap of freq from freqMap
            Map<Integer, Page> mp = freqMap.get(freq);
            
            // Remove it, so that later we can add the updated freq in freqMap
            mp.remove(page.key);
            if(mp.isEmpty()){
                freqMap.remove(freq);
                
                // update minFreq, if freq is same as minFreq
                if(freq == minFreq)
                    minFreq++;
            }
        }
        
        // update the freq value for this key in freqMap
        freqMap.compute(page.freq, (k, v) -> {
            if(v == null)
                v = new LinkedHashMap<>();
            v.remove(page.key);
            v.put(page.key, page);
            return v;
        });
    }
    
    class Page{
        int key;
        int val;
        int freq;
        
        public Page(int key, int val, int freq){
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */